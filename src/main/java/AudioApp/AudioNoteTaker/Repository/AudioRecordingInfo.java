package AudioApp.AudioNoteTaker.Repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class AudioRecordingInfo extends SimpleJpaRepository<AudioRecordingInfo,String> {

    public AudioRecordingInfo(Class<AudioRecordingInfo> domainClass ,EntityManager em) {
        super(domainClass ,em);
    }
}
