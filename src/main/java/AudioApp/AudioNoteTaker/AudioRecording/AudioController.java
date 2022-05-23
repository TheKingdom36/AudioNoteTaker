package AudioApp.AudioNoteTaker.AudioRecording;
import AudioApp.AudioNoteTaker.AudioRecording.RequestResponse.*;
import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import javassist.NotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recordings")
public class AudioController {

    @Autowired
    AudioModelService audioModelService;

    @GetMapping(value = "/{id}",
            produces =   MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public byte[] getAudioRecording(@PathVariable(value = "id") String id)  {
        System.out.println();

        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        ArrayList<String> types = new ArrayList<>();
        types.add("audio/mpeg");
        headers.put("content-type",types);

        ResponseEntity<byte[]> responseEntity = null;
        try {
            responseEntity = new ResponseEntity(audioModelService.findById(Long.parseLong(id)).getAudioData(),headers,HttpStatus.ACCEPTED);
        } catch (NotFoundException exception) {
            //return ResponseEntity.notFound().build();
        } catch (Exception exception) {
            exception.printStackTrace();
        }


        byte[] bytes = responseEntity.getBody();
        return bytes;
    }


    @GetMapping("")
    public ResponseEntity<List<AudioRecordingInfo>> getAudioRecordings(ListAudioRecordingRequest listAudioRecordingRequest) throws NotFoundException {
            return ResponseEntity.ok(audioModelService.findAll(listAudioRecordingRequest));
    }



    @PutMapping(path="")
    public ResponseEntity<?> store(@Valid @ModelAttribute RecordingStoreRequest storeRequest) throws Throwable {

        System.out.println(storeRequest.getFile().getContentType());

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
