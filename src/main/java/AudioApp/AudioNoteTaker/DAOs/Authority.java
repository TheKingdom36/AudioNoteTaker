package AudioApp.AudioNoteTaker.DAOs;



import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
    name = "AUTHORITIES",
    uniqueConstraints = @UniqueConstraint(columnNames = {"USERNAME","AUTHORITY"})
)
@Getter @Setter
public class Authority implements Serializable, GrantedAuthority {

    @Id
    @Column(name="USERNAME")
    private String username;

    @Column(name="AUTHORITY")
    private String authority;

}
