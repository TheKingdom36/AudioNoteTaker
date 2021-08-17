package AudioApp.AudioNoteTaker.Controllers.ReponseRequests.Recording;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter @Setter
@Data
public class ListAudioRecordingRequest {


    List<String> tags;

    String beginDate;

    String endDate;

    public ListAudioRecordingRequest(){
        beginDate =  "1900-12-27";
        endDate = "2900-12-27";

    }

}
