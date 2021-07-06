package AudioApp.AudioNoteTaker.Controllers.ReponseRequests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Getter @Setter
public class ListAudioRecordingRequest {


    Optional<String> tags;


    Optional<String> beginDate;


    Optional<String> endDate;
}
