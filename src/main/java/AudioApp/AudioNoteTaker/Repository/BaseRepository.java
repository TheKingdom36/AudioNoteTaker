package AudioApp.AudioNoteTaker.Repository;

import AudioApp.AudioNoteTaker.DAOs.User;
import AudioApp.AudioNoteTaker.Repository.User.UserRepositoryCustom;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface BaseRepository<Item,ID> extends JpaRepositoryImplementation<Item,ID>, JpaSpecificationExecutor<Item> {
}
