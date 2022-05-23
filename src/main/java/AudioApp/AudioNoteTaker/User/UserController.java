package AudioApp.AudioNoteTaker.User;


import AudioApp.AudioNoteTaker.Repository.BaseRepository;
import AudioApp.AudioNoteTaker.User.RequestResponse.RegisterNewUserRequest;
import AudioApp.AudioNoteTaker.DAOs.Authority;
import AudioApp.AudioNoteTaker.DAOs.User;
import AudioApp.AudioNoteTaker.User.RequestResponse.GetUserResponse;
import AudioApp.AudioNoteTaker.Utils.AuthorityRoles;
import AudioApp.AudioNoteTaker.Utils.LoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

@Autowired
    LoggedInUser loggedInUser;


    @GetMapping("")
    public ResponseEntity<?> getUserInfo(){
        Optional<User> userOptional = userService.findById(loggedInUser.getUser().getID());

        if(userOptional.isPresent() == true) {

            return new ResponseEntity<>(new GetUserResponse(userOptional.get()) ,HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(){

        if(loggedInUser.getUser() != null){
            return new ResponseEntity<>(new GetUserResponse(loggedInUser.getUser()),HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<?> registerNewUser(@ModelAttribute RegisterNewUserRequest requestBody){

        User user = userService.RegisterNewUser(requestBody);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @GetMapping("check")
    public String check(){

        userService.getEntityClass();
        return "String";
    }

}
