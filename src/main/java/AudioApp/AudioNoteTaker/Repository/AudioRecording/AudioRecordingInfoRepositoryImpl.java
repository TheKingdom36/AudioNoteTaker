package AudioApp.AudioNoteTaker.Repository.AudioRecording;

import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Utils.ZonedDateTimeRange;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class AudioRecordingInfoRepositoryImpl implements AudioRepositoryCustom {

    @Override
    public Specification<AudioRecordingInfo> findByTags(List<String> tags) {
        return null;
    }

    @Override
    public Specification<AudioRecordingInfo> findByDate(ZonedDateTimeRange zonedDateTimeRange) {
        return null;
    }
}
