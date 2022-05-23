package AudioApp.AudioNoteTaker.AudioRecording.RequestResponse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class RecordingStoreRequest {

    @NotEmpty(message = "Name cannot be null")
    String file_name;

    List<String> tags;

    @NotNull(message = "File cannot be null")
    MultipartFile file;

}
