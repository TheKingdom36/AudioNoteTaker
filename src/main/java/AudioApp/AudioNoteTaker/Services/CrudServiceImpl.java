package AudioApp.AudioNoteTaker.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;
import java.util.Optional;

abstract class CommonCrudService implements JpaRepository {

    @Autowired
    protected Repo repo;

    @Override
    public <S extends Item> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Item> S update(S entity) {
        return null;
    }

    @Override
    public Optional<Item> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public boolean existsByUuid(String uuid) {
        return false;
    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String id) {

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


}
