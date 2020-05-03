package wellink.test.task.services.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.Log;
import wellink.test.task.entities.materials.ShoeSole;
import wellink.test.task.entities.products.DenimSneakers;
import wellink.test.task.entities.products.Products;
import wellink.test.task.enums.*;
import wellink.test.task.repositories.products.DenimSneakersRepository;
import wellink.test.task.services.LogService;
import wellink.test.task.services.products.DenimSneakersService;
import wellink.test.task.services.products.ProductsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с продуктом "Джинсовые кроссовки"
 */
@Service
public class DenimSneakersServiceImpl implements DenimSneakersService {

    private final String TYPE = DenimSneakers.class.getSimpleName();

    @Autowired
    private DenimSneakersRepository denimSneakersRepository;

    @Autowired
    private LogService logService;

    @Autowired
    ProductsService productsService;

    @Override
    public DenimSneakers save(DenimSneakers entity) {

        DenimSneakers savedDenimSneakers = denimSneakersRepository.save(entity);
        logService.info(entity, Log.Action.SAVE);
        productsService.save(new Products(0L, 0L, 0L, 1L));

        return savedDenimSneakers;
    }

    @Override
    public List<DenimSneakers> saveAll(List<DenimSneakers> entities) {
        List<DenimSneakers> list = new ArrayList<>();

        denimSneakersRepository.saveAll(entities).forEach(list::add);
        logService.info(entities, Log.Action.SAVE);
        productsService.save(new Products(0L, 0L, 0L, (long)entities.size()));

        return list;
    }

    @Override
    public DenimSneakers getById(Long id) {
        return denimSneakersRepository.findById(id).orElse(null);
    }

    @Override
    public List<DenimSneakers> getAll() {
        List<DenimSneakers> list = new ArrayList<>();

        denimSneakersRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public DenimSneakers update(DenimSneakers entity) {
        if (getById(entity.getId()) == null) {
            logService.error("Failed to update - " + TYPE + " does not have id", TYPE, Log.Action.UPDATE);
            return null;
        }

        DenimSneakers updatedDenimSneakers = denimSneakersRepository.save(entity);
        logService.info(entity, Log.Action.UPDATE);

        return updatedDenimSneakers;
    }

    @Override
    public Boolean deleteById(Long id) {
        denimSneakersRepository.deleteById(id);

        if (getById(id) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + id, TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + id + " was deleted", TYPE, Log.Action.DELETE);
        productsService.save(new Products(0L, 0L, 0L, -1L));

        return true;
    }

    @Override
    public Boolean delete(DenimSneakers entity) {
        denimSneakersRepository.delete(entity);

        if (getById(entity.getId()) != null) {
            logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
            return false;
        }

        logService.info(TYPE + " id = " + entity.getId() + " was deleted", TYPE, Log.Action.DELETE);
        productsService.save(new Products(0L, 0L, 0L, -1L));

        return true;
    }

    @Override
    public Boolean deleteAll(List<DenimSneakers> entities) {
        denimSneakersRepository.deleteAll(entities);
        List<Long> idList = new ArrayList<>();

        for (DenimSneakers entity : entities) {
            if (getById(entity.getId()) != null) {
                logService.error("Failed to delete " + TYPE + " id = " + entity.getId(), TYPE, Log.Action.DELETE);
                return false;
            }
            idList.add(entity.getId());
        }

        logService.info(TYPE + " ids = " + idList + " were deleted", TYPE, Log.Action.DELETE);
        productsService.save(new Products(0L, 0L, 0L, -(long)entities.size()));

        return true;
    }

    @Override
    public List<DenimSneakers> getAllByName(String name) {
        return denimSneakersRepository.getAllByName(name);
    }

    @Override
    public List<DenimSneakers> getAllByPrice(Double price) {
        return denimSneakersRepository.getAllByPrice(price);
    }

    @Override
    public List<DenimSneakers> getAllByColor(Color color) {
        return denimSneakersRepository.getAllByColor(color);
    }

    @Override
    public List<DenimSneakers> getAllByColor(Color color, Pageable page) {
        return denimSneakersRepository.getAllByColor(color, page);
    }


    @Override
    public List<DenimSneakers> findAllBySize(Size size) {
        return denimSneakersRepository.findAllBySize(size);
    }

    @Override
    public List<DenimSneakers> findAllByDensity(Density density) {
        return denimSneakersRepository.findAllByDensity(density);
    }

    @Override
    public List<DenimSneakers> findAllByForWhatGender(Gender gender) {
        return denimSneakersRepository.findAllByForWhatGender(gender);
    }

    @Override
    public List<DenimSneakers> findAllByForWhatAge(Age age) {
        return denimSneakersRepository.findAllByForWhatAge(age);
    }


    @Override
    public List<DenimSneakers> findAllByClosureType(ClosureType closureType) {
        return denimSneakersRepository.findAllByClosureType(closureType);
    }

    @Override
    public List<DenimSneakers> findAllBySoleThickness(ShoeSole.SoleThickness thickness) {
        return denimSneakersRepository.findAllBySoleThickness(thickness);
    }

    @Override
    public List<DenimSneakers> findAllByIsInsulated(Boolean isInsulated) {
        return denimSneakersRepository.findAllByIsInsulated(isInsulated);
    }
}
