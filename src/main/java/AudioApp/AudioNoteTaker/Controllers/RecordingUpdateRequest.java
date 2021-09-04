package AudioApp.AudioNoteTaker.Controllers;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class RecordingUpdateRequest {
    private long audioId;

    private String name;

    private List<String> deleteTags;

    private List<String> addTags;

    public RecordingUpdateRequest(){
        this.name = "Unnamed";
        this.deleteTags = new ArrayList<>();
        this.addTags = new ArrayList<>();
        this.audioId = 0L;
    }

}
