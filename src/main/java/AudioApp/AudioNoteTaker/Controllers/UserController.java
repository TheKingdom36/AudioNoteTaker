package AudioApp.AudioNoteTaker.Controllers;


import AudioApp.AudioNoteTaker.Controllers.ReponseRequests.User.RegisterNewUserRequest;
import AudioApp.AudioNoteTaker.DAOs.Authority;
import AudioApp.AudioNoteTaker.DAOs.User;
import AudioApp.AudioNoteTaker.Models.PublicUserInfo;
import AudioApp.AudioNoteTaker.Services.UserService;
import AudioApp.AudioNoteTaker.Utils.AuthorityRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/User")
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

            return new ResponseEntity<>(new PublicUserInfo(userOptional),HttpStatus.OK);
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

    @GetMapping("/gen")
    public ResponseEntity<?> registerNewUser(){


        //System.out.println(userDetailsService.loadUserByUsername("email3"));

        Authority authority = new Authority();

        authority.setAuthority("USER");
        authority.setUsername("email");
        authorityRepo.save(authority);



        String newPass = passwordEncoder.encode("testPassword");

        User user= userService.RegisterNewUser("testDaniel","testMurphy","email",newPass);
        user.setUsername("email");
        user.setEnabled(true);
        user.setAuthority(authority);

        user = userService.save(user);


        return new ResponseEntity<User>(user,HttpStatus.OK);
    }


    @GetMapping("check")
    public String check(){

        userService.getEntityClass();
        return "String";
    }

}
