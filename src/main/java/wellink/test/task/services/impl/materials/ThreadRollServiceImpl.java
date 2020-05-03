package wellink.test.task.services.impl.materials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.Log;
import wellink.test.task.entities.materials.Materials;
import wellink.test.task.entities.materials.ThreadRoll;
import wellink.test.task.enums.Color;
import wellink.test.task.enums.Density;
import wellink.test.task.repositories.materials.ThreadRollRepository;
import wellink.test.task.services.LogService;
import wellink.test.task.services.materials.MaterialsService;
import wellink.test.task.services.materials.ThreadRollService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с материалом "рулон ниток"
 */
@Service
public class ThreadRollServiceImpl implements ThreadRollService {

    private final String TYPE = ThreadRoll.class.getSimpleName();

    @Autowired
    private ThreadRollRepository threadRollRepository;

    @Autowired
    private LogService logService;

    @Autowired
    MaterialsService materialsService;

    @Override
    public ThreadRoll save(ThreadRoll entity) {

        ThreadRoll savedThreadRoll = threadRollRepository.save(entity);
        logService.info(entity, Log.Action.SAVE);
        materialsService.save(new Materials(0L, 0L, 0L, 0L, 0L, 1L));

        return savedThreadRoll;
    }

    @Override
    public List<ThreadRoll> saveAll(List<ThreadRoll> entities) {
        List<ThreadRoll> list = new ArrayList<>();

        threadRollRepository.saveAll(entities).forEach(list::add);
        logService.info(entities, Log.Action.SAVE);
        materialsService.save(new Materials(0L, 0L, 0L, 0L, 0L, (long)entities.size()));

        return list;
    }

    @Override
    public ThreadRoll getById(Long id) {
        return threadRollRepository.findById(id).orElse(null);
    }

    @Override
    public List<ThreadRoll> getAll() {
        List<ThreadRoll> list = new ArrayList<>();

        threadRollRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public ThreadRoll update(ThreadRoll entity) {
        if (getById(entity.getId()) == null) {
            logService.error("Failed to update - " + TYPE + " does not have id", TYPE, Log.Action.UPDATE);
            return null;
        }

        ThreadRoll updatedThreadRoll = threadRollRepository.save(entity);
        logService.info(entity, Log.Action.UPDATE);

        return updatedThreadRoll;
    }

    @Override
    public Boolean deleteById(Long id) {
        threadRollRepository.deleteById(id);

        if (getById(id) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + id, TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + id + " was deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials(0L, 0L, 0L, 0L, 0L, -1L));

        return true;
    }

    @Override
    public Boolean delete(ThreadRoll entity) {
        threadRollRepository.delete(entity);

        if (getById(entity.getId()) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + entity.getId() + " was deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials(0L, 0L, 0L, 0L, 0L, -1L));

        return true;
    }

    @Override
    public Boolean deleteAll(List<ThreadRoll> entities) {
        threadRollRepository.deleteAll(entities);
        List<Long> idList = new ArrayList<>();

        for (ThreadRoll entity : entities) {
            if (getById(entity.getId()) != null) {
                logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
                return false;
            }
            idList.add(entity.getId());
        }

        logService.info(TYPE + " ids = " + idList + " were deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials(0L, 0L, 0L, 0L, 0L, -(long)entities.size()));

        return true;
    }

    @Override
    public List<ThreadRoll> getAllByName(String name) {
        return threadRollRepository.getAllByName(name);
    }

    @Override
    public List<ThreadRoll> getAllByPrice(Double price) {
        return threadRollRepository.getAllByPrice(price);
    }

    @Override
    public List<ThreadRoll> getAllByColor(Color color) {
        return threadRollRepository.getAllByColor(color);
    }

    @Override
    public List<ThreadRoll> getAllByColor(Color color, Pageable page) {
        return threadRollRepository.getAllByColor(color, page);
    }

    @Override
    public List<ThreadRoll> getAllByThreadDensity(Density density) {
        return threadRollRepository.getAllByThreadDensity(density);
    }

    @Override
    public List<ThreadRoll> getAllByThreadLength(Integer length) {
        return threadRollRepository.getAllByThreadLength(length);
    }
}
