package AudioApp.AudioNoteTaker.Repository.User;

import AudioApp.AudioNoteTaker.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface UserRepository extends UserRepositoryCustom, JpaRepositoryImplementation {

}
