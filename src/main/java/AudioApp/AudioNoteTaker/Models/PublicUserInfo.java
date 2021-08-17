package AudioApp.AudioNoteTaker.Models;


import AudioApp.AudioNoteTaker.DAOs.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class PublicUserInfo {

    private long ID;

    private String firstName;

    private String lastName;

    private LocalDateTime joinedDateTime;

    private String email;

    public PublicUserInfo(User user){
        this.ID = user.getID();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.joinedDateTime = user.getJoinedDate();

    }

    public PublicUserInfo(){

    }
}
