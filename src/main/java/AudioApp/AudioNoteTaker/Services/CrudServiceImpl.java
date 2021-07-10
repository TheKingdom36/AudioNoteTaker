package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.Services.Interfaces.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class CrudServiceImpl<Item,ID extends Serializable, Repository extends JpaRepositoryImplementation<Item,ID>> implements CrudService<Item,ID> {

    @Autowired
    Repository repository;


    @Override
    public <S extends Item> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Item> S update(S entity) {
        return null;
    }

    @Override
    public Optional<Item> findOne(ID id) {
        return Optional.empty();
    }

    @Override
    public boolean existsByUuid(String uuid) {
        return false;
    }

    @Override
    public boolean exists(ID id) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(ID id) {

    }

    @Override
    public void delete(Item entity) {

    }

    @Override
    public int delete(List<Item> entityList) {
        return 0;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Class<Item> getEntityClass() {
        return null;
    }
}
