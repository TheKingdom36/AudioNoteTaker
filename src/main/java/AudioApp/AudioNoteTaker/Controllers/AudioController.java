package AudioApp.AudioNoteTaker.Controllers;


import AudioApp.AudioNoteTaker.Builders.AudioRecordingInfoBuilder;
import AudioApp.AudioNoteTaker.Controllers.ReponseRequests.ListAudioRecordingRequest;
import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.DAOs.Tag;
import AudioApp.AudioNoteTaker.Models.AudioModel;
import AudioApp.AudioNoteTaker.Services.AudioModelService;
import AudioApp.AudioNoteTaker.Services.Auth.AuthenticationFacade;
import AudioApp.AudioNoteTaker.Services.DateTimeService;
import AudioApp.AudioNoteTaker.Utils.FileUtils;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static AudioApp.AudioNoteTaker.Repository.AudioRecording.AudioRecordingSpecificationBuilder.hasTags;
import static AudioApp.AudioNoteTaker.Repository.AudioRecording.AudioRecordingSpecificationBuilder.withinDateRange;

@RestController
@RequestMapping("/audio")
public class AudioController {

    @Autowired
    AudioModelService audioModelService;

    @Autowired
    AuthenticationFacade auth;

    @GetMapping("/{id}")
    public ResponseEntity<AudioModel> getAudioRecording(@PathVariable(value = "id") String id) {

        Optional<AudioModel> audioModelOptional = audioModelService.findById(Long.parseLong(id));

        if (audioModelOptional.isEmpty()==false){
            ResponseEntity<AudioModel> responseEntity = new ResponseEntity<>(audioModelOptional.get(),HttpStatus.OK);

            return responseEntity;
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/recordingsInfo")
    public ResponseEntity<List<AudioRecordingInfo>> getAudioRecordings(ListAudioRecordingRequest listAudioRecordingRequest) throws NotFoundException {

        List<String> tags = listAudioRecordingRequest.getTags();
        LocalDate startDate = LocalDate.parse(listAudioRecordingRequest.getBeginDate());
        LocalDate endDate = LocalDate.parse(listAudioRecordingRequest.getEndDate());

        List<AudioRecordingInfo> resultList = audioModelService.findBySpec(Specification
                .where(hasTags(tags)
                        .and(withinDateRange(startDate,endDate))));


        ResponseEntity responseEntity = new ResponseEntity<>(resultList,HttpStatus.OK);

        return responseEntity;

    }


    @PostMapping("/{filename}")
    public ResponseEntity<?> store(@PathVariable(value = "filename") String file_name,@RequestParam("Tag") List<Tag> tags,@RequestParam("file") MultipartFile file) throws IOException, UnsupportedAudioFileException {

        AudioModelService.AudioMetadata metadata = audioModelService.generateAudioFileMetadata(file.getName(), FileUtils.convertMultipartFileToFile(file));

        AudioRecordingInfoBuilder builder = new AudioRecordingInfoBuilder();

        System.out.println(auth.getAuthentication().getName());

        /*
        AudioRecordingInfo info = builder
                .setName(file_name)
                .setContentType(metadata.getFormat())
                .setDateRecorded(dateService.nowDate())
                .setUser(new User())
                .setLength(metadata.getLength())
                .setSize(file.getBytes().length)
                .withTags(tags)
                .build();
        /*


        AudioModel audioModel = new AudioModel(info,newPlainFile.getBytes());

        audioModelService.save(audioModel);
*/
        return new ResponseEntity<>(file_name,HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<?> update(UpdateRequest){

    }


    @GetMapping("/check")
    public ResponseEntity<?> Check() throws NotFoundException {
        List<String> tags = new ArrayList<>();


        List<AudioRecordingInfo> resultList = audioModelService.findBySpec(Specification.where(hasTags(tags)));

        return new ResponseEntity<List<AudioRecordingInfo>>(resultList,HttpStatus.OK);
    }






}
