package AudioApp.AudioNoteTaker.Config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultJwtParserBuilder;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static AudioApp.AudioNoteTaker.Config.SecurityConstants.KEY;


public class JwtUtil {



    /**
     * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
     * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
     *
     * @param token the JWT token to parse
     * @return the User object extracted from specified token or null if a token is invalid.
     */
    public User parseToken(String token) {
        try {
           // String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");

            JwtParserBuilder builder = new DefaultJwtParserBuilder();

            JwtParser parser = builder.setSigningKey(KEY.getBytes()).build();

            Claims body = parser.parseClaimsJws(token).getBody();

            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add((GrantedAuthority) body.get("role"));

            User u = new User(body.getSubject(),null,authorities);

            return u;

        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }

    /**
     * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
     * User object. Tokens validity is infinite.
     *
     * @param u the user for which the token will be generated
     * @return the JWT token
     */
    public String generateToken(User u) {
        String secretKey = KEY;
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("USER");

        String token = Jwts
                .builder()
                .setSubject(u.getUsername())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}