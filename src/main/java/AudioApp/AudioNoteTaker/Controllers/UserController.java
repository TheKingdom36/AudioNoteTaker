package AudioApp.AudioNoteTaker.Controllers;


import AudioApp.AudioNoteTaker.Models.PublicUserInfo;
import AudioApp.AudioNoteTaker.Entities.User;
import AudioApp.AudioNoteTaker.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<PublicUserInfo> getUserInfo(@PathVariable String id){
        User user = userService.find(id);

        return new ResponseEntity<PublicUserInfo>(new PublicUserInfo(user),HttpStatus.OK);
    }
}
