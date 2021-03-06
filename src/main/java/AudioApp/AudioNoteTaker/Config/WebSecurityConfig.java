package AudioApp.AudioNoteTaker.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().antMatchers(HttpMethod.GET, "/token").authenticated().and().httpBasic()
                .and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/recording/**").authenticated()
                .antMatchers(HttpMethod.POST,"/recording/**").authenticated()
                .antMatchers(HttpMethod.GET,"/user/**").authenticated()
                .antMatchers(HttpMethod.GET,"/api/**").authenticated()
                .antMatchers(HttpMethod.POST,"/user/").permitAll();
    }



    @Autowired
    public void configure(AuthenticationManagerBuilder authentication)
            throws Exception
    {
        authentication.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password,enabled "
                        + "from users "
                        + "where username = ?")
                .authoritiesByUsernameQuery("select username,authority "
                        + "from authorities "
                        + "where username = ?").passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public UserDetailsService userDetailsService(AuthenticationManagerBuilder builder) {
        return builder.getDefaultUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
}

}