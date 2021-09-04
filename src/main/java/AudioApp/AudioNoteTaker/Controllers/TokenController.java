package AudioApp.AudioNoteTaker.Controllers;

import AudioApp.AudioNoteTaker.Services.JWTService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TokenController {

    @Autowired
    JWTService jwtService;




    @GetMapping("/token")
    public ResponseEntity<String> getToken(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            System.out.println(principal.toString());

            username = principal.toString();
        }
       // UserDetails userDetails = userDetailsService.loadUserByUsername();


        return new ResponseEntity<String>(jwtService.getJWTToken(username) , HttpStatus.OK);
    }


}
