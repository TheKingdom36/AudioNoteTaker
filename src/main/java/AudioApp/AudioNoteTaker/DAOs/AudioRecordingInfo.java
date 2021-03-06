package AudioApp.AudioNoteTaker.DAOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Getter @Setter
@Entity
@Table(name="AUDIO_RECORDING_INFORMATION")
public class AudioRecordingInfo {
    @Id
    @Column(name="audio_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "audioInfo")
    @Cascade({org.hibernate.annotations.CascadeType.DELETE,org.hibernate.annotations.CascadeType.PERSIST})
    private List<AudioTag> tags;

    private LocalDate createdAt;

    private long size;

    private float length;

    private String filetype;

}
