package AudioApp.AudioNoteTaker.Controllers.ReponseRequests.Recording;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RecordingDeleteRequest {
    long audioId;

    public RecordingDeleteRequest(long audioId){
        this.audioId = audioId;
    }
}
