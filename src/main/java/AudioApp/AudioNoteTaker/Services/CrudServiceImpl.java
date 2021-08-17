package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.Services.Interfaces.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public abstract class CrudServiceImpl<Item,ID extends Serializable> implements CrudService<Item,ID> {

    @Autowired
    CrudRepository<Item,ID> repository;


    @Override
    public <S extends Item> S save(S entity) {

        repository.save(entity);

        return entity;
    }

    @Override
    public <S extends Item> S update(S entity) {

        repository.save(entity);

        return entity;
    }

    @Override
    public Optional<Item> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsByUuid(String uuid) {
        return false;
    }

    @Override
    public boolean exists(ID id) {

        return repository.existsById(id);

    }

    @Override
    public long count() {

        return repository.count();
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Item entity) {
        repository.delete(entity);
    }

    @Override
    public void delete(List<Item> entityList) {
        repository.deleteAll(entityList);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }


}
