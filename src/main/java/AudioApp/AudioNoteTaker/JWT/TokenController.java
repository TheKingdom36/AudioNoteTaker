package AudioApp.AudioNoteTaker.JWT;

import AudioApp.AudioNoteTaker.JWT.RequestResponse.GetTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    JWTService jwtService;

    @GetMapping("/token")
    public ResponseEntity<GetTokenResponse> getToken(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {

            username = principal.toString();
        }


        GetTokenResponse response = new GetTokenResponse(jwtService.getJWTToken(username));


        return new ResponseEntity<>(response , HttpStatus.OK);
    }


}
