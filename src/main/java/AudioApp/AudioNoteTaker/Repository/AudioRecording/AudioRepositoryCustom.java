package AudioApp.AudioNoteTaker.Repository.AudioRecording;

import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Utils.ZonedDateTimeRange;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface AudioRepositoryCustom {

    Specification<AudioRecordingInfo> findByTags(List<String> tags);

    Specification<AudioRecordingInfo> findByDate(ZonedDateTimeRange zonedDateTimeRange);
}
