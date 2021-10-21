package AudioApp.AudioNoteTaker.User.Repository;

import AudioApp.AudioNoteTaker.DAOs.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findByName();
}
