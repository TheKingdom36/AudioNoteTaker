package AudioApp.AudioNoteTaker.Controllers;


import AudioApp.AudioNoteTaker.Controllers.ReponseRequests.ListAudioRecordingRequest;
import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Models.AudioModel;
import AudioApp.AudioNoteTaker.Services.AudioModelService;
import AudioApp.AudioNoteTaker.Services.AudioModleCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/recording")
public class RecordingController {

    @Autowired
    AudioModelService audioModelService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAudioRecording(@PathVariable(value = "id") Optional<Long> id) {
        Optional<AudioModel> audioModelOptional = audioModelService.findOne(id.get());

        if (audioModelOptional.isEmpty()==false){
            ResponseEntity<AudioModel> responseEntity = new ResponseEntity<>(audioModelOptional.get(),HttpStatus.OK);

            return responseEntity;
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<ArrayList<AudioRecordingInfo>> getAudioRecordings(ListAudioRecordingRequest listAudioRecordingRequest) {



        audioModelService.findWith(tags, beginDate,endDate);


        return audioRecordingCrudService.;
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


    @PostMapping("/check")
    public String Check() {


        return "check";
    }



}
