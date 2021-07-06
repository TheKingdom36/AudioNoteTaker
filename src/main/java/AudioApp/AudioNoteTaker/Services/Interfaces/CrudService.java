package AudioApp.AudioNoteTaker.Services.Interfaces;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public interface CrudService<Item, ID extends Serializable> {
    <S extends Item> S save(S entity);

    <S extends Item> S update(S entity);

    Optional<Item> findOne(ID id);

    boolean existsByUuid(String uuid);

    boolean exists(ID id);

    long count();

    void delete(ID id);

    void delete(Item entity);

    int delete(List<Item> entityList);

    void deleteAll();

    Class<Item> getEntityClass();
}
