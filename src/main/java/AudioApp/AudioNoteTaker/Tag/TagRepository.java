package AudioApp.AudioNoteTaker.Tag;

import AudioApp.AudioNoteTaker.DAOs.AudioTag;
import AudioApp.AudioNoteTaker.DAOs.AudioTagId;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepositoryImplementation<AudioTag, AudioTagId> {

}

