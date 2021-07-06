package AudioApp.AudioNoteTaker.Config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties(prefix = "storage")
@PropertySource("classpath:storageconfig.properties")
@Configuration
public class ConfigProperties {


    public String getBaseLocalFileStoragePath() {
        return baseLocalFileStoragePath;
    }

    public void setBaseLocalFileStoragePath(String baseLocalFileStoragePath) {
        this.baseLocalFileStoragePath = baseLocalFileStoragePath;
    }

    private String baseLocalFileStoragePath;

}