package AudioApp.AudioNoteTaker.DAOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter @Setter
@Entity
@Table(name="TAGS")
@IdClass(AudioTagId.class)
public class AudioTag implements Serializable {

    @ManyToOne
    @JoinColumn(name = "audio_id")
    @JsonIgnore
    @Id
    AudioRecordingInfo audioInfo;

    @Id
    String name;

    public AudioTag(){

    }

    public AudioTag(AudioRecordingInfo audioInfo,String name){
        this.audioInfo = audioInfo;
        this.name = name;
    }
}
