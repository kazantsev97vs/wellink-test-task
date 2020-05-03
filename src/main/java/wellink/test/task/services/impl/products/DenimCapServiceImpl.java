package wellink.test.task.services.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.Log;
import wellink.test.task.entities.products.DenimCap;
import wellink.test.task.enums.*;
import wellink.test.task.repositories.products.DenimCapRepository;
import wellink.test.task.services.LogService;
import wellink.test.task.services.products.DenimCapService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с продуктом "Джинсовая кепка"
 */
@Service
public class DenimCapServiceImpl implements DenimCapService {

    private final String TYPE = DenimCap.class.getSimpleName();

    @Autowired
    private DenimCapRepository denimCapRepository;

    @Autowired
    private LogService logService;

    @Override
    public DenimCap save(DenimCap entity) {

        DenimCap savedDenimCap = denimCapRepository.save(entity);
        logService.info(entity, Log.Action.SAVE);

        return savedDenimCap;
    }

    @Override
    public List<DenimCap> saveAll(List<DenimCap> entities) {
        List<DenimCap> list = new ArrayList<>();

        denimCapRepository.saveAll(entities).forEach(list::add);
        logService.info(entities, Log.Action.SAVE);

        return list;
    }

    @Override
    public DenimCap getById(Long id) {
        return denimCapRepository.findById(id).orElse(null);
    }

    @Override
    public List<DenimCap> getAll() {
        List<DenimCap> list = new ArrayList<>();

        denimCapRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public DenimCap update(DenimCap entity) {
        if (getById(entity.getId()) == null) {
            logService.error("Failed to update - " + TYPE + " does not have id", TYPE, Log.Action.UPDATE);
            return null;
        }

        DenimCap updatedDenimCap = denimCapRepository.save(entity);
        logService.info(entity, Log.Action.UPDATE);

        return updatedDenimCap;
    }

    @Override
    public Boolean deleteById(Long id) {
        denimCapRepository.deleteById(id);

        if (getById(id) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + id, TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + id + " was deleted", TYPE, Log.Action.DELETE);
        return true;
    }

    @Override
    public Boolean delete(DenimCap entity) {
        denimCapRepository.delete(entity);

        if (getById(entity.getId()) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + entity.getId() + " was deleted", TYPE, Log.Action.DELETE);
        return true;
    }

    @Override
    public List<DenimCap> getAllByName(String name) {
        return denimCapRepository.getAllByName(name);
    }

    @Override
    public List<DenimCap> getAllByPrice(Double price) {
        return denimCapRepository.getAllByPrice(price);
    }

    @Override
    public List<DenimCap> getAllByColor(Color color) {
        return denimCapRepository.getAllByColor(color);
    }


    @Override
    public List<DenimCap> findAllBySize(Size size) {
        return denimCapRepository.findAllBySize(size);
    }

    @Override
    public List<DenimCap> findAllByDensity(Density density) {
        return denimCapRepository.findAllByDensity(density);
    }

    @Override
    public List<DenimCap> findAllByForWhatGender(Gender gender) {
        return denimCapRepository.findAllByForWhatGender(gender);
    }

    @Override
    public List<DenimCap> findAllByForWhatAge(Age age) {
        return denimCapRepository.findAllByForWhatAge(age);
    }


    @Override
    public List<DenimCap> findAllByCapType(DenimCap.CapType type) {
        return denimCapRepository.findAllByCapType(type);
    }

    @Override
    public List<DenimCap> findAllByVisorLength(Integer length) {
        return denimCapRepository.findAllByVisorLength(length);
    }

    @Override
    public List<DenimCap> findAllByHasCapSizeAdjustment(Boolean hasCapSizeAdjustment) {
        return denimCapRepository.findAllByHasCapSizeAdjustment(hasCapSizeAdjustment);
    }
}
