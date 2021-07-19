package AudioApp.AudioNoteTaker.Repository.User;

import AudioApp.AudioNoteTaker.DAOs.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom{


    @Override
    public List<User> findByName() {


        return null;
    }
}
