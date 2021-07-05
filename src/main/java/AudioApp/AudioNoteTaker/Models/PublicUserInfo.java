package AudioApp.AudioNoteTaker.Models;


import AudioApp.AudioNoteTaker.Entities.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class PublicUserInfo {

    private long ID;

    private String firstName;

    private String lastName;

    private Date joinedDate;

    private String email;

    public PublicUserInfo(User user){
        this.ID = user.getID();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.joinedDate = user.getJoinedDate();
        this.email = user.getEmail();
    }

    public PublicUserInfo(){

    }
}
