package AudioApp.AudioNoteTaker.Models;

import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import lombok.Data;

@Data
public class AudioModel {
    private AudioFile audioFile;

    private AudioRecordingInfo audioRecordingInfo;
}
