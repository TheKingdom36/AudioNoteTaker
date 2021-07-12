package AudioApp.AudioNoteTaker.Controllers;


import AudioApp.AudioNoteTaker.Models.PublicUserInfo;
import AudioApp.AudioNoteTaker.Entities.User;
import AudioApp.AudioNoteTaker.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getUserInfo(@PathVariable String id){
        Optional<User> userOptional = userService.findById(id);

        if(userOptional.isEmpty() == false){
            return new ResponseEntity<>(new PublicUserInfo(userOptional.get()),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }


    }
}
