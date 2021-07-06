package AudioApp.AudioNoteTaker.Config;


import AudioApp.AudioNoteTaker.DataStroage.DataStorageProvider;
import AudioApp.AudioNoteTaker.DataStroage.LocalStorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    DataStorageProvider DataStorageProviderConfig(ConfigProperties configProperties){
        return new LocalStorageProvider(configProperties);
    }
}
