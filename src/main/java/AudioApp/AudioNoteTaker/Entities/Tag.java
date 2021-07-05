package AudioApp.AudioNoteTaker.Entities;

import AudioApp.AudioNoteTaker.DAO.Dao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter @Setter
@Entity
@Table(name="TAGS")
public class Tag implements Dao, Serializable {

    @ManyToOne
    @JoinColumn(name = "audio_id")
    @Id
    AudioRecordingInfo audioInfo;

    @Id
    String name;
}
