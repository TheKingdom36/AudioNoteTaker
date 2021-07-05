package AudioApp.AudioNoteTaker.Entities;

import AudioApp.AudioNoteTaker.DAO.Dao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter @Setter
@Entity
@Table(name="AUDIO_RECORDING_INFORMATION")
public class AudioRecordingInfo implements Dao {
    @Id
    @Column(name="audio_id")
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    private User user;

    @OneToMany(mappedBy = "audioInfo")
    private List<Tag> tags;

    private Date dateRecorded;

    private long size;

    private long length;

}
