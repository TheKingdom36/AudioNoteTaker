package AudioApp.AudioNoteTaker.Repository.User;

import AudioApp.AudioNoteTaker.DAOs.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends UserRepositoryCustom, JpaRepositoryImplementation<User,String> {

}
