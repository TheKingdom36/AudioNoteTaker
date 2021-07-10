package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.Services.Interfaces.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;
=======
import org.springframework.data.repository.CrudRepository;
>>>>>>> Stashed changes

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

<<<<<<< Updated upstream
@Service
public class CrudServiceImpl<Item,ID extends Serializable, Repository extends JpaRepositoryImplementation<Item,ID>> implements CrudService<Item,ID> {
=======
 abstract class CrudServiceImpl<Item,ID extends Serializable, Repo extends CrudRepository> implements CrudService<Item,ID > {
>>>>>>> Stashed changes

    @Autowired
    Repository repository;



     @Override
     public <S extends Item> S save(S entity) {
         repo.save(entity);

<<<<<<< Updated upstream
    @Override
    public Optional<Item> findOne(ID id) {
        return Optional.empty();
    }
=======
         return entity;
     }
>>>>>>> Stashed changes

     @Override
     public <S extends Item> S update(S entity) {
         repo.save(entity);
         return entity;
     }

<<<<<<< Updated upstream
    @Override
    public boolean exists(ID id) {
        return false;
    }
=======
     @Override
     public Optional<Item> findOne(ID id) {
         return repo.findById(id);
     }
>>>>>>> Stashed changes

     @Override
     public boolean existsByUuid(String uuid) {
         return false;
     }

<<<<<<< Updated upstream
    @Override
    public void delete(ID id) {
=======
     @Override
     public boolean exists(ID id) {
         return repo.existsById(id);
     }
>>>>>>> Stashed changes

     @Override
     public long count() {
         return repo.count();
     }

     @Override
     public void delete(ID id) {
        repo.deleteById(id);
     }

     @Override
     public void delete(Item entity) {
        repo.delete(entity);
     }

     @Override
     public void delete(List<Item> entityList) {
         repo.deleteAll(entityList);
     }

     @Override
     public void deleteAll() {
        repo.deleteAll();
     }


<<<<<<< Updated upstream
    @Override
    public Class<Item> getEntityClass() {
        return null;
    }
}
=======
 }
>>>>>>> Stashed changes
