package AudioApp.AudioNoteTaker.Repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<Item,ID> extends JpaRepositoryImplementation<Item, ID>, JpaSpecificationExecutor<Item>, CrudRepository<Item, ID> {
}
