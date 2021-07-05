package AudioApp.AudioNoteTaker.Repository.User;

import AudioApp.AudioNoteTaker.Entities.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findByName();
}
