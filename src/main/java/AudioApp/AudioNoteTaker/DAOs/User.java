package AudioApp.AudioNoteTaker.DAOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name="Users",
        uniqueConstraints = @UniqueConstraint(columnNames = {"USERNAME"})
)
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long ID;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastName;

    @Column(name="JOINDATE")
    private LocalDateTime joinedDate;

    @Column(name="DISPLAYNAME")
    private String displayName;

    /**
     * The username will be the users email
     */
    @Column(name="USERNAME")
    private String username;

    @Column(name="ACCOUNTNONEXPIRED")
    @JsonIgnore
    private boolean accountNonExpired;

    @Column(name="ACCOUNTNONLOCKED")
    @JsonIgnore
    private boolean accountNonLocked;

    @Column(name="CREDENTIALSNONEXPIRED")
    @JsonIgnore
    private boolean credentialsNonExpired;

    @OneToOne
    @JoinColumn(name = "USERNAME",insertable=false,updatable = false)
    private Authority authority;

    @Column(name="PASSWORD")
    @JsonIgnore
    private String password;

    @Column(name="ENABLED")
    private boolean enabled;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<AudioRecordingInfo> audioRecordingInfoSet;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<Authority> authorities = new ArrayList<>();

        authorities.add(authority);
        return authorities;
    }
}
