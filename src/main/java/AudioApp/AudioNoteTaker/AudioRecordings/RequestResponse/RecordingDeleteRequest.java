package AudioApp.AudioNoteTaker.AudioRecordings.RequestResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RecordingDeleteRequest {
    long id;

    public RecordingDeleteRequest(long id){
        this.id = id;
    }
}
