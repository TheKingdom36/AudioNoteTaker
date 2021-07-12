package AudioApp.AudioNoteTaker.Controllers;


import AudioApp.AudioNoteTaker.Controllers.ReponseRequests.ListAudioRecordingRequest;
import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Entities.Tag;
import AudioApp.AudioNoteTaker.Models.AudioModel;
import AudioApp.AudioNoteTaker.Services.AudioModelService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static AudioApp.AudioNoteTaker.Repository.AudioRecording.AudioRecordingSpecificationBuilder.withDateRange;
import static AudioApp.AudioNoteTaker.Repository.AudioRecording.AudioRecordingSpecificationBuilder.withTags;

@RestController
@RequestMapping("/recording")
public class RecordingController {

    @Autowired
    AudioModelService audioModelService;

    @GetMapping("/Audio/{id}")
    public ResponseEntity<AudioModel> getAudioRecording(@PathVariable(value = "id") Optional<String> id) {

        Optional<AudioModel> audioModelOptional = audioModelService.findById(Long.parseLong(id.get()));

        if (audioModelOptional.isEmpty()==false){
            ResponseEntity<AudioModel> responseEntity = new ResponseEntity<>(audioModelOptional.get(),HttpStatus.OK);

            return responseEntity;
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<AudioRecordingInfo>> getAudioRecordings(ListAudioRecordingRequest listAudioRecordingRequest) throws NotFoundException {

        List<String> tags = listAudioRecordingRequest.getTags();
        String startDate = listAudioRecordingRequest.getBeginDate();
        String endDate = listAudioRecordingRequest.getEndDate();

       // List<AudioRecordingInfo> resultList = audioModelService.findBySpec(Specification.where(withTags(list).and(withDateRange(null,null))));
       // ResponseEntity responseEntity = new ResponseEntity<List<AudioRecordingInfo>>(resultList,HttpStatus.OK);

        //return responseEntity;

return null;

    }

    @PostMapping("/stor")
    public ResponseEntity<AudioRecordingInfo> store(@RequestBody String audioBase64Encoded) {


        //TODO Change
        return new ResponseEntity<AudioRecordingInfo>(new AudioRecordingInfo() ,HttpStatus.OK);
    }


    @PostMapping("/store")
    public ResponseEntity<?> store(@RequestBody MultipartFile file) {


        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        return new ResponseEntity<>(fileName,HttpStatus.OK);
    }


    @GetMapping("/check")
    public ResponseEntity<?> Check() throws NotFoundException {
        List<String> tags = new ArrayList<>();
        System.out.println("hhere");
        tags.add("red");

        List<AudioRecordingInfo> resultList = audioModelService.findBySpec(Specification.where(withTags(tags)));

        return new ResponseEntity<List<AudioRecordingInfo>>(resultList,HttpStatus.OK);
    }



}
