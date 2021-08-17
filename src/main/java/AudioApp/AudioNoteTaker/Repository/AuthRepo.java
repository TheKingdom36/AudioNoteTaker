package AudioApp.AudioNoteTaker.Repository;

import AudioApp.AudioNoteTaker.DAOs.Authority;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface AuthRepo extends JpaRepositoryImplementation<Authority,String> {
}
