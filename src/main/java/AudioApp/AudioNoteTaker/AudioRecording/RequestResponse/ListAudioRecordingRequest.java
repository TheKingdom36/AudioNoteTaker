package AudioApp.AudioNoteTaker.AudioRecording.RequestResponse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Data
public class ListAudioRecordingRequest {

    String name;

    List<String> tags;

    String beginDate;

    String endDate;

    public ListAudioRecordingRequest(){
        beginDate =  "1900-12-27";
        endDate = "2900-12-27";
        name = "";
        tags =  new ArrayList<>();
    }

}
