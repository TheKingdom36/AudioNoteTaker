package AudioApp.AudioNoteTaker.Controllers;


import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Models.AudioFile;
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
    AudioModleCrudService audioRecordingCrudService;

    @GetMapping("/{id}")
    public ResponseEntity<AudioFile> getAudioRecording(@PathVariable(value = "id") Optional<String> id) {
        return null;
    }

    @GetMapping("/list")
    public ResponseEntity<ArrayList<AudioRecordingInfo>> getAudioRecordings(@RequestParam(value = "tags") Optional<String> tags,@RequestParam(value = "Date") Optional<String> date) {
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
