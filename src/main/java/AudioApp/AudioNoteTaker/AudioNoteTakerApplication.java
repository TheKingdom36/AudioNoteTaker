package AudioApp.AudioNoteTaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AudioNoteTakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudioNoteTakerApplication.class, args);
	}

}
