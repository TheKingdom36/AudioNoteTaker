package AudioApp.AudioNoteTaker.Controllers.ReponseRequests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

@Getter @Setter
public class ListAudioRecordingRequest {


    List<String> tags;

    @Pattern(regexp = "[A-Z]")
    String beginDate;

    @Pattern(regexp = "[A-Z]")
    String endDate;
}
