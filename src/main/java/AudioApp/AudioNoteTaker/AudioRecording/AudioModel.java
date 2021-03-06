package AudioApp.AudioNoteTaker.AudioRecording;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import lombok.Data;

@Data
public class AudioModel {
    private byte[] audioData;

    private AudioRecordingInfo audioRecordingInfo;

    public AudioModel(){

    }

    public AudioModel(AudioRecordingInfo info, byte[] audioData){
        this.audioData = audioData;
        this.audioRecordingInfo = info;
    }


}
