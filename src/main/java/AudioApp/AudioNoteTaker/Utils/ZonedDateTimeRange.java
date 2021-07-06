package AudioApp.AudioNoteTaker.Utils;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class ZonedDateTimeRange {
    ZonedDateTime startTime;
    ZonedDateTime endTime;
    ZoneId zoneId;


    public ZonedDateTimeRange(ZonedDateTime startTime, ZonedDateTime endTime){

        this.startTime = startTime;
        this.endTime = endTime;
        zoneId = ZoneId.of("UTC+00:00");
    }

    public ZonedDateTimeRange(LocalDateTime startLocalTime, LocalDateTime endLocalTime, String zone){
        zoneId = ZoneId.of(zone);

        startTime = startLocalTime.atZone(zoneId);

        endTime = endLocalTime.atZone(zoneId);

    }
}
