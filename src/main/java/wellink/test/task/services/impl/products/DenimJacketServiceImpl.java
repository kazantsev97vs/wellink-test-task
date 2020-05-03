package wellink.test.task.services.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.Log;
import wellink.test.task.entities.products.DenimJacket;
import wellink.test.task.entities.products.Products;
import wellink.test.task.enums.*;
import wellink.test.task.repositories.products.DenimJacketRepository;
import wellink.test.task.services.LogService;
import wellink.test.task.services.products.DenimJacketService;
import wellink.test.task.services.products.ProductsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с продуктом "Джинсовая куртка"
 */
@Service
public class DenimJacketServiceImpl implements DenimJacketService {

    private final String TYPE = DenimJacket.class.getSimpleName();

    @Autowired
    private DenimJacketRepository denimJacketRepository;

    @Autowired
    private LogService logService;

    @Autowired
    ProductsService productsService;

    @Override
    public DenimJacket save(DenimJacket entity) {

        DenimJacket savedDenimJacket = denimJacketRepository.save(entity);
        logService.info(entity, Log.Action.SAVE);
        productsService.save(new Products(0L, 1L, 0L, 0L));

        return savedDenimJacket;
    }

    @Override
    public List<DenimJacket> saveAll(List<DenimJacket> entities) {
        List<DenimJacket> list = new ArrayList<>();

        denimJacketRepository.saveAll(entities).forEach(list::add);
        logService.info(entities, Log.Action.SAVE);
        productsService.save(new Products(0L, (long)entities.size(), 0L, 0L));

        return list;
    }

    @Override
    public DenimJacket getById(Long id) {
        return denimJacketRepository.findById(id).orElse(null);
    }

    @Override
    public List<DenimJacket> getAll() {
        List<DenimJacket> list = new ArrayList<>();

        denimJacketRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public DenimJacket update(DenimJacket entity) {
        if (getById(entity.getId()) == null) {
            logService.error("Failed to update - " + TYPE + " does not have id", TYPE, Log.Action.UPDATE);
            return null;
        }

        DenimJacket updatedDenimJacket = denimJacketRepository.save(entity);
        logService.info(entity, Log.Action.UPDATE);

        return updatedDenimJacket;
    }

    @Override
    public Boolean deleteById(Long id) {
        denimJacketRepository.deleteById(id);

        if (getById(id) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + id, TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + id + " was deleted", TYPE, Log.Action.DELETE);
        productsService.save(new Products(0L, -1L, 0L, 0L));

        return true;
    }

    @Override
    public Boolean delete(DenimJacket entity) {
        denimJacketRepository.delete(entity);

        if (getById(entity.getId()) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + entity.getId() + " was deleted", TYPE, Log.Action.DELETE);
        productsService.save(new Products(0L, -1L, 0L, 0L));
        return true;
    }

    @Override
    public Boolean deleteAll(List<DenimJacket> entities) {
        denimJacketRepository.deleteAll(entities);
        List<Long> idList = new ArrayList<>();

        for (DenimJacket entity : entities) {
            if (getById(entity.getId()) != null) {
                logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
                return false;
            }
            idList.add(entity.getId());
        }

        logService.info(TYPE + " ids = " + idList + " were deleted", TYPE, Log.Action.DELETE);
        productsService.save(new Products(0L, -(long)entities.size(), 0L, 0L));
        return true;
    }

    @Override
    public List<DenimJacket> getAllByName(String name) {
        return denimJacketRepository.getAllByName(name);
    }

    @Override
    public List<DenimJacket> getAllByPrice(Double price) {
        return denimJacketRepository.getAllByPrice(price);
    }

    @Override
    public List<DenimJacket> getAllByColor(Color color) {
        return denimJacketRepository.getAllByColor(color);
    }

    @Override
    public List<DenimJacket> getAllByColor(Color color, Pageable page) {
        return denimJacketRepository.getAllByColor(color, page);
    }

    @Override
    public List<DenimJacket> findAllBySize(Size size) {
        return denimJacketRepository.findAllBySize(size);
    }

    @Override
    public List<DenimJacket> findAllByDensity(Density density) {
        return denimJacketRepository.findAllByDensity(density);
    }

    @Override
    public List<DenimJacket> findAllByForWhatGender(Gender gender) {
        return denimJacketRepository.findAllByForWhatGender(gender);
    }

    @Override
    public List<DenimJacket> findAllByForWhatAge(Age age) {
        return denimJacketRepository.findAllByForWhatAge(age);
    }


    @Override
    public List<DenimJacket> findAllByHasHood(Boolean hasHood) {
        return denimJacketRepository.findAllByHasHood(hasHood);
    }

    @Override
    public List<DenimJacket> findAllByPocketsNumber(Integer pocketsNumber) {
        return denimJacketRepository.findAllByPocketsNumber(pocketsNumber);
    }

    @Override
    public List<DenimJacket> findAllBySleeveLength(Integer sleeveLength) {
        return denimJacketRepository.findAllBySleeveLength(sleeveLength);
    }

    @Override
    public List<DenimJacket> findAllByIsInsulated(Boolean isInsulated) {
        return denimJacketRepository.findAllByIsInsulated(isInsulated);
    }

    @Override
    public List<DenimJacket> findAllByClosureType(ClosureType type) {
        return denimJacketRepository.findAllByClosureType(type);
    }
}
