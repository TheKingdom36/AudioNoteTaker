package AudioApp.AudioNoteTaker.AudioRecordings.RequestResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RecordingDeleteRequest {
    long audioId;

    public RecordingDeleteRequest(long audioId){
        this.audioId = audioId;
    }
}
