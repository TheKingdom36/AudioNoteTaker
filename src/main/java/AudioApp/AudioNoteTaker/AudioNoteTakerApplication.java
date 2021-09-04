package AudioApp.AudioNoteTaker;

import AudioApp.AudioNoteTaker.Services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories
public class AudioNoteTakerApplication {

	public static void main(String[] args) {


		SpringApplication.run(AudioNoteTakerApplication.class, args);
	}

}
