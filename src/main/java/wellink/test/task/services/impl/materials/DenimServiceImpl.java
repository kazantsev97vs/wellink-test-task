package wellink.test.task.services.impl.materials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.Log;
import wellink.test.task.entities.materials.Denim;
import wellink.test.task.entities.materials.Materials;
import wellink.test.task.enums.Color;
import wellink.test.task.enums.Density;
import wellink.test.task.repositories.materials.DenimRepository;
import wellink.test.task.services.LogService;
import wellink.test.task.services.materials.DenimService;
import wellink.test.task.services.materials.MaterialsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с материалом "джинсовая ткань"
 */
@Service
public class DenimServiceImpl implements DenimService {

    private final String TYPE = Denim.class.getSimpleName();
    
    @Autowired
    private DenimRepository denimRepository;

    @Autowired
    private LogService logService;

    @Autowired
    MaterialsService materialsService;

    @Override
    public Denim save(Denim entity) {

        Denim savedDenim = denimRepository.save(entity);
        logService.info(entity, Log.Action.SAVE);
        materialsService.save(new Materials(0L, 1L, 0L, 0L, 0L, 0L));

        return savedDenim;
    }

    @Override
    public List<Denim> saveAll(List<Denim> entities) {
        List<Denim> list = new ArrayList<>();

        denimRepository.saveAll(entities).forEach(list::add);
        logService.info(entities, Log.Action.SAVE);
        materialsService.save(new Materials(0L, (long)entities.size(), 0L, 0L, 0L, 0L));

        return list;
    }

    @Override
    public Denim getById(Long id) {
        return denimRepository.findById(id).orElse(null);
    }

    @Override
    public List<Denim> getAll() {
        List<Denim> list = new ArrayList<>();

        denimRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public Denim update(Denim entity) {
        if (getById(entity.getId()) == null) {
            logService.error("Failed to update - " + TYPE + " does not have id", TYPE, Log.Action.UPDATE);
            return null;
        }

        Denim updatedDenim = denimRepository.save(entity);
        logService.info(entity, Log.Action.UPDATE);

        return updatedDenim;
    }

    @Override
    public Boolean deleteById(Long id) {
        denimRepository.deleteById(id);

        if (getById(id) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + id, TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + id + " was deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials(0L, -1L, 0L, 0L, 0L, 0L));

        return true;
    }

    @Override
    public Boolean delete(Denim entity) {
        denimRepository.delete(entity);

        if (getById(entity.getId()) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + entity.getId() + " was deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials(0L, -1L, 0L, 0L, 0L, 0L));

        return true;
    }

    @Override
    public Boolean deleteAll(List<Denim> entities) {
        denimRepository.deleteAll(entities);
        List<Long> idList = new ArrayList<>();

        for (Denim entity : entities) {
            if (getById(entity.getId()) != null) {
                logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
                return false;
            }
            idList.add(entity.getId());
        }

        logService.info(TYPE + " ids = " + idList + " were deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials(0L, -(long)entities.size(), 0L, 0L, 0L, 0L));

        return true;
    }


    @Override
    public List<Denim> getAllByName(String name) {
        return denimRepository.getAllByName(name);
    }

    @Override
    public List<Denim> getAllByPrice(Double price) {
        return denimRepository.getAllByPrice(price);
    }

    @Override
    public List<Denim> getAllByColor(Color color) {
        return denimRepository.getAllByColor(color);
    }

    @Override
    public List<Denim> getAllByColor(Color color, Pageable page) {
        return denimRepository.getAllByColor(color, page);
    }

    @Override
    public List<Denim> getAllByDensity(Density density) {
        return denimRepository.getAllByDensity(density);
    }
}
