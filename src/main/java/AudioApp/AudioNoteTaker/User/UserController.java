package AudioApp.AudioNoteTaker.User;


import AudioApp.AudioNoteTaker.User.RequestResponse.RegisterNewUserRequest;
import AudioApp.AudioNoteTaker.DAOs.Authority;
import AudioApp.AudioNoteTaker.DAOs.User;
import AudioApp.AudioNoteTaker.User.RequestResponse.GetUserResponse;
import AudioApp.AudioNoteTaker.Utils.AuthorityRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    JpaRepositoryImplementation<Authority,String> authorityRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserInfo(@PathVariable String id){
        User userOptional = userService.findById(Long.parseLong(id));

            return new ResponseEntity<>(new GetUserResponse(userOptional),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> registerNewUser(@RequestBody RegisterNewUserRequest requestBody){

        System.out.println(requestBody.toString());

        Authority authority = new Authority();

        authority.setAuthority(AuthorityRoles.USER.toString());
        authority.setUsername(requestBody.getEmail());
        authorityRepo.save(authority);

        String newPass = passwordEncoder.encode("password");

        User user= userService.RegisterNewUser("Daniel","Murphy","email",newPass);
        user.setEnabled(true);
        user.setAuthority(authority);

        user = userService.save(user);

        return new ResponseEntity<>(requestBody,HttpStatus.OK);
    }


    @GetMapping("check")
    public String check(){

        userService.getEntityClass();
        return "String";
    }

}
