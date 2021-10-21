package AudioApp.AudioNoteTaker.Utils;

import AudioApp.AudioNoteTaker.DAOs.Builders.UserBuilder;
import AudioApp.AudioNoteTaker.DAOs.User;
import AudioApp.AudioNoteTaker.User.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import static AudioApp.AudioNoteTaker.User.Repository.UserSpecificationsBuilder.hasUsername;

@Component
public class LoggedInUser {
    @Autowired
    UserService userService;

    public User getUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();

        String username="";


            try {

                if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = (String) principal;
            }

            User user = userService.findBySpec(Specification.where(hasUsername(username))).get(0);


            return user;
        } catch (NotFoundException e) {

                return AnonymousUser();

            }
    }

    private User AnonymousUser(){


        User anon = UserBuilder.newBuilder()
                .setName("Anon","Anon")
                .setUsername("Anon")
                .withAudioRecordings()
                .setPassword("").build();


        return anon;
    }

}
