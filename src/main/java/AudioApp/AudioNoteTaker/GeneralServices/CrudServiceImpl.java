package AudioApp.AudioNoteTaker.GeneralServices;

import AudioApp.AudioNoteTaker.GeneralServices.Interfaces.CrudService;
import AudioApp.AudioNoteTaker.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class CrudServiceImpl<Item,ID extends Serializable> implements CrudService<Item,ID> {

    @Autowired
    protected BaseRepository<Item,ID> repository;


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
    public Item findById(ID id) {
        return repository.findById(id).orElseThrow();
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
