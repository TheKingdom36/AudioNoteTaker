package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.Builders.UserBuilder;
import AudioApp.AudioNoteTaker.DAOs.User;
import AudioApp.AudioNoteTaker.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudServiceImpl<User,String, UserRepository> {


    @Autowired
    DateTimeService dateService;


    public UserService(){

    }

    public User create(String firstname,String lastname,String email, String password){

        User newUser = UserBuilder.newBuilder()
                .setName(firstname,lastname)
                .setEmail(email)
                .setJoinedDate(dateService.nowDateTime())
                .setPassword(password).build();

        return newUser;
    }



    @Override
    public Class<User> getEntityClass() {
        return null;
    }
}
