package wellink.test.task.services.materials;

import wellink.test.task.entities.materials.Materials;

/**
 * CRUD-сервис для работы с материалами
 */
public interface MaterialsService {

    Materials save(Materials materials);

    Materials getById(Long id);

    Materials update(Materials materials);

    Boolean delete(Materials materials);

}
