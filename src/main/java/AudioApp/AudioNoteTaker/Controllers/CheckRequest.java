package AudioApp.AudioNoteTaker.Controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class CheckRequest {
    String name;

    List<String> tags;

    MultipartFile file;

    public CheckRequest(){
        name = "default";
        tags = new ArrayList<>();
    }
}
