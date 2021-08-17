package AudioApp.AudioNoteTaker.Config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultJwtParserBuilder;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;


import static AudioApp.AudioNoteTaker.Config.SecurityConstants.*;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    public AuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_NAME);

        if (header == null) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = authenticate(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request) {
        String token = request.getHeader(HEADER_NAME);
        if (token != null) {

/*
            JwtParserBuilder builder = new DefaultJwtParserBuilder();

            builder.setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes()));


            Claims user = builder.build().parseClaimsJwt(token).getBody();


            Claims user = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes()))
                    .parseClaimsJwt(token)
                    .getBody();*/

            String user = createJWT();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }else{
                return  null;
            }

        }
        return null;
    }

    public static String createJWT( ) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, signingKey);


        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
}