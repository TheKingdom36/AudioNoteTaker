package AudioApp.AudioNoteTaker.Repository;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.DAOs.AudioTag;
import AudioApp.AudioNoteTaker.DAOs.AudioTagId;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;

@Repository
public interface TagRepository extends JpaRepositoryImplementation<AudioTag, AudioTagId> {

}

