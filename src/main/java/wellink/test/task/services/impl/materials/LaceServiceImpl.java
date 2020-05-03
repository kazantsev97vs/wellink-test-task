package wellink.test.task.services.impl.materials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.Log;
import wellink.test.task.entities.materials.Lace;
import wellink.test.task.entities.materials.Materials;
import wellink.test.task.enums.Color;
import wellink.test.task.enums.Density;
import wellink.test.task.repositories.materials.LaceRepository;
import wellink.test.task.services.LogService;
import wellink.test.task.services.materials.LaceService;
import wellink.test.task.services.materials.MaterialsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с материалом "шнурок"
 */
@Service
public class LaceServiceImpl implements LaceService {

    private final String TYPE = Lace.class.getSimpleName();

    @Autowired
    private LaceRepository laceRepository;

    @Autowired
    private LogService logService;

    @Autowired
    MaterialsService materialsService;

    @Override
    public Lace save(Lace entity) {

        Lace savedLace = laceRepository.save(entity);
        logService.info(entity, Log.Action.SAVE);
        materialsService.save(new Materials(0L, 0L, 1L, 0L, 0L, 0L));

        return savedLace;
    }

    @Override
    public List<Lace> saveAll(List<Lace> entities) {
        List<Lace> list = new ArrayList<>();

        laceRepository.saveAll(entities).forEach(list::add);
        logService.info(entities, Log.Action.SAVE);
        materialsService.save(new Materials(0L, 0L, (long)entities.size(), 0L, 0L, 0L));

        return list;
    }

    @Override
    public Lace getById(Long id) {
        return laceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lace> getAll() {
        List<Lace> list = new ArrayList<>();

        laceRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public Lace update(Lace entity) {
        if (getById(entity.getId()) == null) {
            logService.error("Failed to update - " + TYPE + " does not have id", TYPE, Log.Action.UPDATE);
            return null;
        }

        Lace updatedLace = laceRepository.save(entity);
        logService.info(entity, Log.Action.UPDATE);

        return updatedLace;
    }

    @Override
    public Boolean deleteById(Long id) {
        laceRepository.deleteById(id);

        if (getById(id) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + id, TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + id + " was deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials(0L, 0L, -1L, 0L, 0L, 0L));

        return true;
    }

    @Override
    public Boolean delete(Lace entity) {
        laceRepository.delete(entity);

        if (getById(entity.getId()) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + entity.getId() + " was deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials(0L, 0L, -1L, 0L, 0L, 0L));

        return true;
    }

    @Override
    public Boolean deleteAll(List<Lace> entities) {
        laceRepository.deleteAll(entities);
        List<Long> idList = new ArrayList<>();

        for (Lace entity : entities) {
            if (getById(entity.getId()) != null) {
                logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
                return false;
            }
            idList.add(entity.getId());
        }

        logService.info(TYPE + " ids = " + idList + " were deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials(0L, 0L, -(long)entities.size(), 0L, 0L, 0L));
        return true;
    }


    @Override
    public List<Lace> getAllByName(String name) {
        return laceRepository.getAllByName(name);
    }

    @Override
    public List<Lace> getAllByPrice(Double price) {
        return laceRepository.getAllByPrice(price);
    }

    @Override
    public List<Lace> getAllByColor(Color color) {
        return laceRepository.getAllByColor(color);
    }

    @Override
    public List<Lace> getAllByColor(Color color, Pageable page) {
        return laceRepository.getAllByColor(color, page);
    }

    @Override
    public List<Lace> getAllByLength(Integer length) {
        return laceRepository.getAllByLength(length);
    }

    @Override
    public List<Lace> getAllByDensity(Density density) {
        return laceRepository.getAllByDensity(density);
    }
}
