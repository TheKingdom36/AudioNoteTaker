package AudioApp.AudioNoteTaker.DAOs;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter @Setter
public class AudioTagId implements Serializable {

    private AudioRecordingInfo audioInfo;

    private String name;

    public AudioTagId(){

    }

    public AudioTagId(AudioRecordingInfo audioInfo,String name){
        this.audioInfo = audioInfo;
        this.name = name;
    }
}
