package AudioApp.AudioNoteTaker.Repository.User;

import AudioApp.AudioNoteTaker.DAOs.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findByName();
}
