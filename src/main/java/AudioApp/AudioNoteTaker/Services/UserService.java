package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.Builders.UserBuilder;
import AudioApp.AudioNoteTaker.DAOs.User;
import AudioApp.AudioNoteTaker.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudServiceImpl<User, Long> {


    @Autowired
    DateTimeService dateService;

    @Autowired
    UserDetailsService userDetailsService;

    public UserService(){

    }

    public User RegisterNewUser(String firstname,String lastname,String email,String password){


        System.out.println(password);

        User newUser = UserBuilder.newBuilder()
                .setName(firstname,lastname)
                .setEmail(email)
                .setJoinedDate(dateService.nowDateTime())
                .setPassword(password).build();
        System.out.println(newUser.getPassword());
        return newUser;
    }



    @Override
    public Class<User> getEntityClass() {
        return null;
    }

}
