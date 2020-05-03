package wellink.test.task.services.impl.materials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.Log;
import wellink.test.task.entities.materials.ShoeSole;
import wellink.test.task.enums.Color;
import wellink.test.task.repositories.materials.ShoeSoleRepository;
import wellink.test.task.services.LogService;
import wellink.test.task.services.materials.ShoeSoleService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с материалом "подошва для обуви"
 */
@Service
public class ShoeSoleServiceImpl implements ShoeSoleService {

    private final String TYPE = ShoeSole.class.getSimpleName();

    @Autowired
    private ShoeSoleRepository shoeSoleRepository;

    @Autowired
    private LogService logService;

    @Override
    public ShoeSole save(ShoeSole entity) {

        ShoeSole savedShoeSole = shoeSoleRepository.save(entity);
        logService.info(entity, Log.Action.SAVE);

        return savedShoeSole;
    }

    @Override
    public List<ShoeSole> saveAll(List<ShoeSole> entities) {
        List<ShoeSole> list = new ArrayList<>();

        shoeSoleRepository.saveAll(entities).forEach(list::add);
        logService.info(entities, Log.Action.SAVE);

        return list;
    }

    @Override
    public ShoeSole getById(Long id) {
        return shoeSoleRepository.findById(id).orElse(null);
    }

    @Override
    public List<ShoeSole> getAll() {
        List<ShoeSole> list = new ArrayList<>();

        shoeSoleRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public ShoeSole update(ShoeSole entity) {
        if (getById(entity.getId()) == null) {
            logService.error("Failed to update - " + TYPE + " does not have id", TYPE, Log.Action.UPDATE);
            return null;
        }

        ShoeSole updatedShoeSole = shoeSoleRepository.save(entity);
        logService.info(entity, Log.Action.UPDATE);

        return updatedShoeSole;
    }

    @Override
    public Boolean deleteById(Long id) {
        shoeSoleRepository.deleteById(id);

        if (getById(id) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + id, TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + id + " was deleted", TYPE, Log.Action.DELETE);
        return true;
    }

    @Override
    public Boolean delete(ShoeSole entity) {
        shoeSoleRepository.delete(entity);

        if (getById(entity.getId()) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + entity.getId() + " was deleted", TYPE, Log.Action.DELETE);
        return true;
    }

    @Override
    public List<ShoeSole> getAllByName(String name) {
        return shoeSoleRepository.getAllByName(name);
    }

    @Override
    public List<ShoeSole> getAllByPrice(Double price) {
        return shoeSoleRepository.getAllByPrice(price);
    }

    @Override
    public List<ShoeSole> getAllByColor(Color color) {
        return shoeSoleRepository.getAllByColor(color);
    }

    @Override
    public List<ShoeSole> getAllByThickness(ShoeSole.SoleThickness thickness) {
        return shoeSoleRepository.getAllByThickness(thickness);
    }
}
