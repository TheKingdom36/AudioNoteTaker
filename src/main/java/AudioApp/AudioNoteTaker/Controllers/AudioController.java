package AudioApp.AudioNoteTaker.Controllers;
import AudioApp.AudioNoteTaker.Controllers.ReponseRequests.Recording.ListAudioRecordingRequest;
import AudioApp.AudioNoteTaker.Controllers.ReponseRequests.Recording.RecordingDeleteRequest;
import AudioApp.AudioNoteTaker.Controllers.ReponseRequests.Recording.RecordingStoreRequest;
import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Models.AudioModel;
import AudioApp.AudioNoteTaker.Services.AudioModelService;
import AudioApp.AudioNoteTaker.Services.Auth.LoggedInUser;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/recordings")
public class AudioController {

    @Autowired
    AudioModelService audioModelService;

    @Autowired
    LoggedInUser loggedInUser;

    @GetMapping("/{id}")
    public ResponseEntity<AudioModel> getAudioRecording(@PathVariable(value = "id") String id) throws Exception {
            return ResponseEntity.ok(audioModelService.findById(Long.parseLong(id)));
    }


    @GetMapping("")
    public ResponseEntity<List<AudioRecordingInfo>> getAudioRecordings(ListAudioRecordingRequest listAudioRecordingRequest) throws NotFoundException {
            return ResponseEntity.ok(audioModelService.findAll(listAudioRecordingRequest));
    }


    @PutMapping(path="")
    public ResponseEntity<?> store(@ModelAttribute RecordingStoreRequest storeRequest) throws IOException {
        System.out.println("Hello");
        return ResponseEntity.ok(audioModelService.save(storeRequest));
    }

    @DeleteMapping(path="")
    public ResponseEntity<?> delete(RecordingDeleteRequest deleteRequest) throws NotFoundException {
        return ResponseEntity.ok(audioModelService.delete(deleteRequest));
    }

    @PatchMapping(path="")
    public ResponseEntity<?> update(RecordingUpdateRequest updateRequest) throws Exception {
        return ResponseEntity.ok(audioModelService.updateAudioInfo(updateRequest));
    }

    @GetMapping(path="check")
    public ResponseEntity<String> Check(@ModelAttribute CheckRequest name) throws NotFoundException {

        System.out.println(name.getTags().get(1));

        return new ResponseEntity<String>( name.getFile().toString(),HttpStatus.OK);
    }

}
