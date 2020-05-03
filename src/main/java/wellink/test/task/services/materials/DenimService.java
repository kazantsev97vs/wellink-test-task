package wellink.test.task.services.materials;

import wellink.test.task.entities.materials.Denim;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;
import wellink.test.task.interfaces.materialsSearch.DenimSearchMethods;


/**
 * CRUD-сервис для работы с материалом "джинсовая ткань"
 */
public interface DenimService extends
        BasicCRUDService<Denim>, BasicSearchMaterialMethods<Denim>, DenimSearchMethods {
}
