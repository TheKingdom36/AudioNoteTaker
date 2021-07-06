package AudioApp.AudioNoteTaker.Repository.AudioRecording;

import AudioApp.AudioNoteTaker.Utils.ZonedDateTimeRange;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class AudioRecordingInfoRepositoryImpl extends SimpleJpaRepository<AudioRecordingInfoRepositoryImpl,String> implements AudioRepositoryCustom {

    public AudioRecordingInfoRepositoryImpl(Class<AudioRecordingInfoRepositoryImpl> domainClass , EntityManager em) {
        super(domainClass ,em);
    }

    @Override
    public Specification<AudioRecordingInfoRepositoryImpl> findByTags(List<String> tags) {
        return null;
    }

    @Override
    public Specification<AudioRecordingInfoRepositoryImpl> findByDate(ZonedDateTimeRange zonedDateTimeRange) {
        return null;
    }
}
