package wellink.test.task.services.impl.materials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.Log;
import wellink.test.task.entities.materials.Lock;
import wellink.test.task.enums.Color;
import wellink.test.task.repositories.materials.LockRepository;
import wellink.test.task.services.LogService;
import wellink.test.task.services.materials.LockService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с материалом "замок"
 */
@Service
public class LockServiceImpl implements LockService {

    private final String TYPE = Lock.class.getSimpleName();

    @Autowired
    private LockRepository lockRepository;

    @Autowired
    private LogService logService;

    @Override
    public Lock save(Lock entity) {

        Lock savedLock = lockRepository.save(entity);
        logService.info(entity, Log.Action.SAVE);

        return savedLock;
    }

    @Override
    public List<Lock> saveAll(List<Lock> entities) {
        List<Lock> list = new ArrayList<>();

        lockRepository.saveAll(entities).forEach(list::add);
        logService.info(entities, Log.Action.SAVE);

        return list;
    }

    @Override
    public Lock getById(Long id) {
        return lockRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lock> getAll() {
        List<Lock> list = new ArrayList<>();

        lockRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public Lock update(Lock entity) {
        if (getById(entity.getId()) == null) {
            logService.error("Failed to update - " + TYPE + " does not have id", TYPE, Log.Action.UPDATE);
            return null;
        }

        Lock updatedLock = lockRepository.save(entity);
        logService.info(entity, Log.Action.UPDATE);

        return updatedLock;
    }

    @Override
    public Boolean deleteById(Long id) {
        lockRepository.deleteById(id);

        if (getById(id) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + id, TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + id + " was deleted", TYPE, Log.Action.DELETE);
        return true;
    }

    @Override
    public Boolean delete(Lock entity) {
        lockRepository.delete(entity);

        if (getById(entity.getId()) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + entity.getId() + " was deleted", TYPE, Log.Action.DELETE);
        return true;
    }

    @Override
    public List<Lock> getAllByName(String name) {
        return lockRepository.getAllByName(name);
    }

    @Override
    public List<Lock> getAllByPrice(Double price) {
        return lockRepository.getAllByPrice(price);
    }

    @Override
    public List<Lock> getAllByColor(Color color) {
        return lockRepository.getAllByColor(color);
    }

}
