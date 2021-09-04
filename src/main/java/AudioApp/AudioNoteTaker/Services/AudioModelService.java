package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.Builders.AudioRecordingInfoBuilder;
import AudioApp.AudioNoteTaker.Controllers.RecordingUpdateRequest;
import AudioApp.AudioNoteTaker.Controllers.ReponseRequests.Recording.ListAudioRecordingRequest;
import AudioApp.AudioNoteTaker.Controllers.ReponseRequests.Recording.RecordingDeleteRequest;
import AudioApp.AudioNoteTaker.Controllers.ReponseRequests.Recording.RecordingStoreRequest;
import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.DAOs.AudioTag;
import AudioApp.AudioNoteTaker.Models.AudioModel;
import AudioApp.AudioNoteTaker.Repository.AudioRecording.AudioRecordingInfoRepository;
import AudioApp.AudioNoteTaker.Services.Auth.LoggedInUser;
import AudioApp.AudioNoteTaker.Utils.FileUtils;
import javassist.NotFoundException;
import lombok.Getter;
import lombok.SneakyThrows;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp4.Mp4AudioHeader;
import org.jaudiotagger.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static AudioApp.AudioNoteTaker.Repository.AudioRecording.AudioRecordingSpecificationBuilder.hasUserId;
import static AudioApp.AudioNoteTaker.Repository.AudioRecording.AudioRecordingSpecificationBuilder.withinDateRange;

@Service
public class AudioModelService {

    @Autowired
    AudioFileService audioFileService;

    @Autowired
    AudioRecordingInfoRepository audioRecordingInfoRepo;

    @Autowired
    LoggedInUser loggedInUser;

    @Autowired
    DateTimeService dateTimeService;

    @Autowired
    TagService tagService;

    /*
    Just supports mp4 compatible files
     */
    public AudioMetadata generateAudioFileMetadata(String fileName,File audioFile){

        AudioRecordingInfoBuilder builder = new AudioRecordingInfoBuilder();
        AudioFile audiofile = null;
        Tag tag = null;
        Mp4AudioHeader audioHeader=null;

        try {
            audiofile = AudioFileIO.read(audioFile);
            tag = audiofile.getTag();
            audioHeader= (Mp4AudioHeader) audiofile.getAudioHeader();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // After operating the above files, you need to delete the temporary files generated in the root directory
            File f = new File(audioFile.toURI());
            f.delete();
        }


        return new AudioMetadata(audioHeader);

    }

    public AudioRecordingInfo save(RecordingStoreRequest request) throws IOException {

        byte[] bytes = request.getFile().getBytes();

        File file = FileUtils.convertMultipartFileToFile(request.getFile());

        AudioMetadata metadata = generateAudioFileMetadata(request.getFile_name(), file);

        AudioRecordingInfo info = new AudioRecordingInfoBuilder()
                .setName(request.getFile_name())
                .setContentType(metadata.getFormat())
                .setDateRecorded(dateTimeService.nowDate())
                .setUser(loggedInUser.getUser())
                .setLength(metadata.getLength())
                .setSize(bytes.length)
                .withTags(new ArrayList<>())
                .build();

        List<AudioTag> audioTags = tagService.getOrCreateTags(info,request.getTags());
        info.setAudioTags(audioTags);

        audioRecordingInfoRepo.save(info);

        String fileName = String.valueOf(info.getId());
        String userID = String.valueOf(loggedInUser.getUser().getID());

        audioFileService.save(bytes,fileName,userID);

        return info;
    }

    public AudioRecordingInfo updateAudioInfo(RecordingUpdateRequest updateRequest) throws Exception {

        AudioRecordingInfo alteredInfo = audioRecordingInfoRepo
                .findById(updateRequest.getAudioId()).map(audioRecordingInfo -> {

                    if(isValidAudioName(updateRequest.getName())){
                        audioRecordingInfo.setName(updateRequest.getName());
                    }

                    audioRecordingInfo.getAudioTags().stream().map(audioTag -> {

                        updateRequest.getDeleteTags().stream().map(audioTagToDeleteString->{

                           if(audioTag.getName() == audioTagToDeleteString){
                               audioRecordingInfo.getAudioTags().remove(audioTag);
                           }

                           return audioTagToDeleteString;
                        });


                        return audioTag;
                    });

            updateRequest.getAddTags().stream().map(audioTagToAddString->{
                audioRecordingInfo.getAudioTags().add(tagService.getOrCreateTag(audioRecordingInfo,audioTagToAddString));
                return audioTagToAddString;
            });

                    return audioRecordingInfo;
        }).orElseThrow((Supplier<Exception>) () -> new RuntimeException("Could not find audio info"));

        audioRecordingInfoRepo.save(alteredInfo);

        return alteredInfo;
    }

    private boolean isValidAudioName(String name) {
        if(name == ""){
            return false;
        }
        return true;
    }

    public AudioModel findById(Long ID) throws Exception {


        AudioModel model = new AudioModel();
        AudioRecordingInfo audioInfo =
                audioRecordingInfoRepo
                        .findById(ID).map( audioRecordingInfo -> {
                    if (!audioRecordingInfo.getId().equals(loggedInUser.getUser().getID())) {
                        throw new AccessDeniedException("Access denied");
                    }

                    return audioRecordingInfo;
                }).orElseThrow((Supplier<Exception>) () -> new RuntimeException("Could not find audio info"));

        model.setAudioRecordingInfo(audioInfo);

        model.setAudioData(audioFileService.findOne(audioInfo.getName(),String.valueOf(audioInfo.getId())));

        return model;
    }

    public List<AudioRecordingInfo> findBySpec(Specification<AudioRecordingInfo> specification) {

        List<AudioRecordingInfo> audioRecordingInfoList = audioRecordingInfoRepo.findAll(specification);

        return audioRecordingInfoList;
    }



    public List<AudioRecordingInfo> findAll(ListAudioRecordingRequest listAudioRecordingRequest) {

        List<String> audioTags = listAudioRecordingRequest.getTags();
        LocalDate startDate = LocalDate.parse(listAudioRecordingRequest.getBeginDate());
        LocalDate endDate = LocalDate.parse(listAudioRecordingRequest.getEndDate());

        Specification specification = Specification.where(withinDateRange(startDate,endDate));

        List<AudioRecordingInfo> resultList = findBySpec(Specification
                .where(withinDateRange(startDate,endDate))
                .and(hasUserId(loggedInUser.getUser().getID())));

        return resultList;
    }

    public RecordingDeleteResponse delete(RecordingDeleteRequest deleteRequest) throws NotFoundException {

        Optional<AudioRecordingInfo> audioInfoOptional =  audioRecordingInfoRepo.findById(deleteRequest.getAudioId());

        if(!audioInfoOptional.isPresent()){
            throw new NotFoundException("Unable to find the audio file");
        }

        audioFileService.delete(String.valueOf(audioInfoOptional.get().getId()),String.valueOf(loggedInUser.getUser().getID()));


        audioRecordingInfoRepo.delete(audioInfoOptional.get());

        return new RecordingDeleteResponse(audioInfoOptional.get().getId());
    }

    @Getter
    public static class AudioMetadata{

        String format;
        float length;
        Long bitrate;

        public AudioMetadata(Mp4AudioHeader header){
            this.format = header.getFormat();
            this.length = header.getPreciseLength();
            this.bitrate = header.getBitRateAsNumber();

        }
    }
}
