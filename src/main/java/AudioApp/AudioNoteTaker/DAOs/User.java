package AudioApp.AudioNoteTaker.DAOs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name="Users")
public class User implements Dao {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long ID;

    @Column(name="USER_FIRST_NAME")
    private String firstName;

    @Column(name="USER_LAST_NAME")
    private String lastName;

    @Column(name="USER_JOIN_DATE")
    private LocalDateTime joinedDate;

    @Column(name="USER_EMAIL")
    private String email;

    @Column(name="USER_PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<AudioRecordingInfo> audioRecordingInfoSet;

}
