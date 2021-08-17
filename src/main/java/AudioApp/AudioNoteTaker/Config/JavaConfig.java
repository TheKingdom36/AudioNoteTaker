package AudioApp.AudioNoteTaker.Config;


import AudioApp.AudioNoteTaker.DataStroage.DataStorageProvider;
import AudioApp.AudioNoteTaker.DataStroage.LocalStorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.EntityInformation;

@Configuration
public class JavaConfig {

    @Bean
    DataStorageProvider DataStorageProviderConfig(ConfigProperties configProperties){
        return new LocalStorageProvider(configProperties);
    }


}
