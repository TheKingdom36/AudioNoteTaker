package AudioApp.AudioNoteTaker.User;

import AudioApp.AudioNoteTaker.DAOs.Authority;
import AudioApp.AudioNoteTaker.DAOs.Builders.UserBuilder;
import AudioApp.AudioNoteTaker.DAOs.User;
import AudioApp.AudioNoteTaker.Repository.BaseRepository;
import AudioApp.AudioNoteTaker.User.Repository.UserRepository;
import AudioApp.AudioNoteTaker.User.RequestResponse.RegisterNewUserRequest;
import AudioApp.AudioNoteTaker.UtilServices.CrudServiceImpl;
import AudioApp.AudioNoteTaker.UtilServices.DateTimeService;
import AudioApp.AudioNoteTaker.Utils.AuthorityRoles;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends CrudServiceImpl<User, Long> {


    @Autowired
    DateTimeService dateService;

    @Autowired
    JpaRepositoryImplementation<Authority,String> authorityRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService(){
    }

    public User RegisterNewUser(RegisterNewUserRequest requestBody){


        Authority authority = new Authority();

        authority.setAuthority(AuthorityRoles.USER.toString());
        authority.setUsername(requestBody.getEmail());
        authorityRepo.save(authority);

        String newPass = passwordEncoder.encode("password");

        User newUser = UserBuilder.newBuilder()
                .setName(requestBody.getFirstName(),requestBody.getLastName())
                .setUsername(requestBody.getEmail())
                .setDisplayName(requestBody.getFirstName() + " " + requestBody.getLastName())
                .setJoinedDate(dateService.nowDateTime())
                .setPassword(newPass)
                .setEnabled(true)
                .setAuthority(authority).build();

        userRepository.save(newUser);
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
