package AudioApp.AudioNoteTaker.Services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DateService {

    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}


