package AudioApp.AudioNoteTaker.User.Repository;

import AudioApp.AudioNoteTaker.DAOs.User;
import AudioApp.AudioNoteTaker.Repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends UserRepositoryCustom, BaseRepository<User,Long> {

}
