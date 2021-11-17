package AudioApp.AudioNoteTaker.AudioRecording.RequestResponse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class RecordingStoreRequest {


    String file_name;

    List<String> tags;

    MultipartFile file;

    public RecordingStoreRequest(){
        file_name = "New recording";

        tags = new ArrayList<>();

        file =null;
    }
}
