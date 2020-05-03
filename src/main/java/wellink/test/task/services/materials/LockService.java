package wellink.test.task.services.materials;

import wellink.test.task.entities.materials.Lock;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;


/**
 * CRUD-сервис для работы с материалом "замок"
 */
public interface LockService extends
        BasicCRUDService<Lock>, BasicSearchMaterialMethods<Lock> {
}
