package AudioApp.AudioNoteTaker.Repository.AudioRecording;

import AudioApp.AudioNoteTaker.Utils.ZonedDateTimeRange;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface AudioRepositoryCustom {

    Specification<AudioRecordingInfoRepositoryImpl> findByTags(List<String> tags);

    Specification<AudioRecordingInfoRepositoryImpl> findByDate(ZonedDateTimeRange zonedDateTimeRange);
}
