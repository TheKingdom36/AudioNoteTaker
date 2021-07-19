package AudioApp.AudioNoteTaker.DAOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnore
    @Id
    AudioRecordingInfo audioInfo;

    @Id
    String name;
}
