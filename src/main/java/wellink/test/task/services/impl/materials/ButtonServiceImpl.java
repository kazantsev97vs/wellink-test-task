package wellink.test.task.services.impl.materials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.Log;
import wellink.test.task.entities.materials.Button;
import wellink.test.task.entities.materials.Materials;
import wellink.test.task.enums.Color;
import wellink.test.task.repositories.materials.ButtonRepository;
import wellink.test.task.services.LogService;
import wellink.test.task.services.materials.ButtonService;
import wellink.test.task.services.materials.MaterialsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с материалом "пуговица"
 */
@Service
public class ButtonServiceImpl implements ButtonService {

    private final String TYPE = Button.class.getSimpleName();

    @Autowired
    private ButtonRepository buttonRepository;

    @Autowired
    private LogService logService;

    @Autowired
    private MaterialsService materialsService;

    @Override
    public Button save(Button entity) {

        Button savedButton = buttonRepository.save(entity);
        logService.info(entity, Log.Action.SAVE);
        materialsService.save(new Materials(1L, 0L, 0L, 0L, 0L, 0L));

        return savedButton;
    }

    @Override
    public List<Button> saveAll(List<Button> entities) {
        List<Button> list = new ArrayList<>();

        buttonRepository.saveAll(entities).forEach(list::add);
        logService.info(entities, Log.Action.SAVE);
        materialsService.save(new Materials((long) entities.size(), 0L, 0L, 0L, 0L, 0L));

        return list;
    }

    @Override
    public Button getById(Long id) {
        return buttonRepository.findById(id).orElse(null);
    }

    @Override
    public List<Button> getAll() {
        List<Button> list = new ArrayList<>();

        buttonRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public Button update(Button entity) {
        if (getById(entity.getId()) == null) {
            logService.error("Failed to update - " + TYPE + " does not have id", TYPE, Log.Action.UPDATE);
            return null;
        }

        Button updatedButton = buttonRepository.save(entity);
        logService.info(entity, Log.Action.UPDATE);

        return updatedButton;
    }

    @Override
    public Boolean deleteById(Long id) {
        buttonRepository.deleteById(id);

        if (getById(id) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + id, TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + id + " was deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials(-1L, 0L, 0L, 0L, 0L, 0L));

        return true;
    }

    @Override
    public Boolean delete(Button entity) {
        buttonRepository.delete(entity);

        if (getById(entity.getId()) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + entity.getId() + " was deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials(-1L, 0L, 0L, 0L, 0L, 0L));

        return true;
    }

    @Override
    public Boolean deleteAll(List<Button> entities) {
        buttonRepository.deleteAll(entities);
        List<Long> idList = new ArrayList<>();

        for (Button entity : entities) {
            if (getById(entity.getId()) != null) {
                logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
                return false;
            }
            idList.add(entity.getId());
        }

        logService.info(TYPE + " ids = " + idList + " were deleted", TYPE, Log.Action.DELETE);
        materialsService.save(new Materials( (long)entities.size() * -1, 0L, 0L, 0L, 0L, 0L));

        return true;
    }

    @Override
    public List<Button> getAllByName(String name) {
        return buttonRepository.getAllByName(name);
    }

    @Override
    public List<Button> getAllByPrice(Double price) {
        return buttonRepository.getAllByPrice(price);
    }

    @Override
    public List<Button> getAllByColor(Color color) {
        return buttonRepository.getAllByColor(color);
    }

    @Override
    public List<Button> getAllByColor(Color color, Pageable page) {
        return buttonRepository.getAllByColor(color, page);
    }
}
