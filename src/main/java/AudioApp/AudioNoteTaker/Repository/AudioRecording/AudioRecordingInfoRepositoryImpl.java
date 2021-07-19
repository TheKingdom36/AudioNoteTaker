package AudioApp.AudioNoteTaker.Repository.AudioRecording;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Utils.ZonedDateTimeRange;
import org.springframework.data.jpa.domain.Specification;

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
