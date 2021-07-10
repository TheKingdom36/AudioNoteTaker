package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.Builders.UserBuilder;
import AudioApp.AudioNoteTaker.Entities.User;
import AudioApp.AudioNoteTaker.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
<<<<<<< Updated upstream
public class UserService extends CrudServiceImpl<User,String, UserRepository> {
=======
public class UserService extends CrudServiceImpl<User,Long, UserRepository> {
>>>>>>> Stashed changes


    @Autowired
    DateService dateService;


    public UserService(){

    }

    public User create(String firstname,String lastname,String email, String password){

        User newUser = UserBuilder.newBuilder()
                .setName(firstname,lastname)
                .setEmail(email)
                .setJoinedDate(dateService.now())
                .setPassword(password).build();

        return newUser;
    }



    @Override
    public Class<User> getEntityClass() {
        return null;
    }
}
