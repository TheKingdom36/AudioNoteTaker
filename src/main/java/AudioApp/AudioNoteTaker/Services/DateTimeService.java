package AudioApp.AudioNoteTaker.Services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DateTimeService {

    public LocalDateTime nowDateTime() {
        return LocalDateTime.now();
    }

    public LocalDate nowDate() {
        return LocalDate.now();
    }

}


