package wellink.test.task.services.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.Log;
import wellink.test.task.entities.products.DenimPants;
import wellink.test.task.entities.products.Products;
import wellink.test.task.enums.*;
import wellink.test.task.repositories.products.DenimPantsRepository;
import wellink.test.task.services.LogService;
import wellink.test.task.services.products.DenimPantsService;
import wellink.test.task.services.products.ProductsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с продуктом "Джинсовые штаны"
 */
@Service
public class DenimPantsServiceImpl implements DenimPantsService {

    private final String TYPE = DenimPants.class.getSimpleName();

    @Autowired
    private DenimPantsRepository denimPantsRepository;

    @Autowired
    private LogService logService;

    @Autowired
    ProductsService productsService;

    @Override
    public DenimPants save(DenimPants entity) {

        DenimPants savedDenimPants = denimPantsRepository.save(entity);
        logService.info(entity, Log.Action.SAVE);
        productsService.save(new Products(0L, 0L, 1L, 0L));

        return savedDenimPants;
    }

    @Override
    public List<DenimPants> saveAll(List<DenimPants> entities) {
        List<DenimPants> list = new ArrayList<>();

        denimPantsRepository.saveAll(entities).forEach(list::add);
        logService.info(entities, Log.Action.SAVE);
        productsService.save(new Products(0L, 0L, (long)entities.size(), 0L));

        return list;
    }

    @Override
    public DenimPants getById(Long id) {
        return denimPantsRepository.findById(id).orElse(null);
    }

    @Override
    public List<DenimPants> getAll() {
        List<DenimPants> list = new ArrayList<>();

        denimPantsRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public DenimPants update(DenimPants entity) {
        if (getById(entity.getId()) == null) {
            logService.error("Failed to update - " + TYPE + " does not have id", TYPE, Log.Action.UPDATE);
            return null;
        }

        DenimPants updatedDenimPants = denimPantsRepository.save(entity);
        logService.info(entity, Log.Action.UPDATE);

        return updatedDenimPants;
    }

    @Override
    public Boolean deleteById(Long id) {
        denimPantsRepository.deleteById(id);

        if (getById(id) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + id, TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + id + " was deleted", TYPE, Log.Action.DELETE);
        productsService.save(new Products(0L, 0L, -1L, 0L));
        return true;
    }

    @Override
    public Boolean delete(DenimPants entity) {
        denimPantsRepository.delete(entity);

        if (getById(entity.getId()) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + entity.getId() + " was deleted", TYPE, Log.Action.DELETE);
        productsService.save(new Products(0L, 0L, -1L, 0L));
        return true;
    }

    @Override
    public Boolean deleteAll(List<DenimPants> entities) {
        denimPantsRepository.deleteAll(entities);
        List<Long> idList = new ArrayList<>();

        for (DenimPants entity : entities) {
            if (getById(entity.getId()) != null) {
                logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
                return false;
            }
            idList.add(entity.getId());
        }

        logService.info(TYPE + " ids = " + idList + " were deleted", TYPE, Log.Action.DELETE);
        productsService.save(new Products(0L, 0L, -(long)entities.size(), 0L));
        return true;
    }

    @Override
    public List<DenimPants> getAllByName(String name) {
        return denimPantsRepository.getAllByName(name);
    }

    @Override
    public List<DenimPants> getAllByPrice(Double price) {
        return denimPantsRepository.getAllByPrice(price);
    }

    @Override
    public List<DenimPants> getAllByColor(Color color) {
        return denimPantsRepository.getAllByColor(color);
    }

    @Override
    public List<DenimPants> getAllByColor(Color color, Pageable page) {
        return denimPantsRepository.getAllByColor(color, page);
    }


    @Override
    public List<DenimPants> findAllBySize(Size size) {
        return denimPantsRepository.findAllBySize(size);
    }

    @Override
    public List<DenimPants> findAllByDensity(Density density) {
        return denimPantsRepository.findAllByDensity(density);
    }

    @Override
    public List<DenimPants> findAllByForWhatGender(Gender gender) {
        return denimPantsRepository.findAllByForWhatGender(gender);
    }

    @Override
    public List<DenimPants> findAllByForWhatAge(Age age) {
        return denimPantsRepository.findAllByForWhatAge(age);
    }


    @Override
    public List<DenimPants> findAllByIsSkinny(Boolean isSkinny) {
        return denimPantsRepository.findAllByIsSkinny(isSkinny);
    }

    @Override
    public List<DenimPants> findAllByIsStretch(Boolean isStretch) {
        return denimPantsRepository.findAllByIsStretch(isStretch);
    }

    @Override
    public List<DenimPants> findAllByClosureType(ClosureType type) {
        return denimPantsRepository.findAllByClosureType(type);
    }

    @Override
    public List<DenimPants> findAllByIsInsulated(Boolean isInsulated) {
        return denimPantsRepository.findAllByIsInsulated(isInsulated);
    }
}
