package AudioApp.AudioNoteTaker.AudioRecordings.RequestResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RecordingDeleteResponse {
    private long id;

    public RecordingDeleteResponse(long id){
        this.id = id;
    }
}
