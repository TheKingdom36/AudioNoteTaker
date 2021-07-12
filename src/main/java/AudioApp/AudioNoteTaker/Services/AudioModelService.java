package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Models.AudioModel;
import AudioApp.AudioNoteTaker.Repository.AudioRecording.AudioRecordingInfoRepository;
import AudioApp.AudioNoteTaker.Services.Interfaces.CrudService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AudioModelService implements CrudService<AudioModel,Long> {

    @Autowired
    AudioFileService audioFileService;

    @Autowired
    AudioRecordingInfoRepository audioRecordingInfoRepo;

    @Override
    public <S extends AudioModel> S save(S entity) {


        audioRecordingInfoRepo.save(entity.getAudioRecordingInfo());

        String fileName = String.valueOf(entity.getAudioRecordingInfo().getId());
        String directory = String.valueOf(entity.getAudioRecordingInfo().getUser().getID());

        audioFileService.save(entity.getAudioData(),fileName,directory);

        return entity;
    }

    @Override
    public <S extends AudioModel> S update(S entity) {
        //find current
        /*audioRecordingInfoService.
        //reject if updating id



        //update info
        audioRecordingInfoService.save(entity.getAudioRecordingInfo());
        //update data

        String fileName = String.valueOf(entity.getAudioRecordingInfo().getId());
        String directory = String.valueOf(entity.getAudioRecordingInfo().getUser().getID());

        audioFileService.update(entity.getAudioData(),fileName,directory);

*/
        return null;
    }

    public AudioRecordingInfo updateAudioInfo(AudioRecordingInfo info){

        audioRecordingInfoRepo.save(info);

        return info;
    }

    @Override
    public Optional<AudioModel> findById(Long ID) {


        AudioModel model = new AudioModel();
        byte[] audioData;
        Optional<AudioRecordingInfo> infoOptional = audioRecordingInfoRepo.findById(ID);
        Optional<AudioModel> modelOptional;

        if (infoOptional.isEmpty()){
            return Optional.empty();
        }else {
            model.setAudioRecordingInfo(infoOptional.get());
            try {
                model.setAudioData(audioFileService.findOne(infoOptional.get().getName(),String.valueOf(infoOptional.get().getId())));
            } catch (NotFoundException e) {
                return Optional.empty();
            }
            modelOptional = Optional.of(model);
        }

        return modelOptional;
    }

    public List<AudioRecordingInfo> findBySpec(Specification<AudioRecordingInfo> specification) throws NotFoundException {

        List<AudioRecordingInfo> audioRecordingInfoList = audioRecordingInfoRepo.findAll(specification);

        return audioRecordingInfoList;

    }


    @Override
    public boolean existsByUuid(String uuid) {
        return false;
    }

    @Override
    public boolean exists(Long ID) {
        return audioRecordingInfoRepo.existsById(ID);
    }

    @Override
    public long count() {
        return audioRecordingInfoRepo.count();
    }

    @Override
    public void delete(Long ID) {

    }

    @Override
    public void delete(AudioModel entity) {

    }

    @Override
    public void delete(List<AudioModel> entityList) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Class<AudioModel> getEntityClass() {
        return null;
    }
}
