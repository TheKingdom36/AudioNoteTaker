package AudioApp.AudioNoteTaker.User;

import AudioApp.AudioNoteTaker.DAOs.Builders.UserBuilder;
import AudioApp.AudioNoteTaker.DAOs.User;
import AudioApp.AudioNoteTaker.UtilServices.CrudServiceImpl;
import AudioApp.AudioNoteTaker.UtilServices.DateTimeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends CrudServiceImpl<User, Long> {


    @Autowired
    DateTimeService dateService;

    public UserService(){
    }

    public User RegisterNewUser(String firstname,String lastname,String email,String password){

        User newUser = UserBuilder.newBuilder()
                .setName(firstname,lastname)
                .setUsername(email)
                .setDisplayName(firstname + " " + lastname)
                .setJoinedDate(dateService.nowDateTime())
                .setPassword(password).build();
        System.out.println(newUser.getPassword());
        return newUser;
    }


    public List<User> findBySpec(Specification<User> specification) throws NotFoundException {


        List<User> userList = repository.findAll(specification);

        return userList;
    }


    @Override
    public Class<User> getEntityClass() {

        System.out.println(repository.toString());
        return null;
    }

}
