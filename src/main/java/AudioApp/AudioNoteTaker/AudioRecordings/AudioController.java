package AudioApp.AudioNoteTaker.AudioRecordings;
import AudioApp.AudioNoteTaker.AudioRecordings.RequestResponse.*;
import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/recordings")
public class AudioController {

    @Autowired
    AudioModelService audioModelService;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getAudioRecording(@PathVariable(value = "id") String id) throws Exception {
        System.out.println();

        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        ArrayList<String> types = new ArrayList<>();
        types.add("audio/mp4");
        headers.put("content-type",types);

        ResponseEntity<byte[]> responseEntity = new ResponseEntity(audioModelService.findById(Long.parseLong(id)).getAudioData(),headers,HttpStatus.ACCEPTED);

            return responseEntity;
    }


    @GetMapping("")
    public ResponseEntity<List<AudioRecordingInfo>> getAudioRecordings(ListAudioRecordingRequest listAudioRecordingRequest) throws NotFoundException {
            return ResponseEntity.ok(audioModelService.findAll(listAudioRecordingRequest));
    }


    @PutMapping(path="")
    public ResponseEntity<?> store(@ModelAttribute RecordingStoreRequest storeRequest) throws Throwable {
        return ResponseEntity.ok(audioModelService.save(storeRequest));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String audioId)  {
        RecordingDeleteRequest request = new RecordingDeleteRequest(Integer.parseInt(audioId));

        ResponseEntity<?> entity;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type","application/json");
            RecordingDeleteResponse response = audioModelService.delete(request);
            entity = ResponseEntity.ok().body(response);

        } catch (NotFoundException e) {
            entity = ResponseEntity.notFound().build();
        }
        return entity;
    }

    @PatchMapping(path="")
    public ResponseEntity<?> update(RecordingUpdateRequest updateRequest) throws Exception {
        return ResponseEntity.ok(audioModelService.updateAudioInfo(updateRequest));
    }


}
