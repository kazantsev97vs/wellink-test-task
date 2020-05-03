package wellink.test.task.services.materials;

import wellink.test.task.entities.materials.ShoeSole;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;
import wellink.test.task.interfaces.materialsSearch.ShoeSoleSearchMethods;


/**
 * CRUD-сервис для работы с материалом "подошва для обуви"
 */
public interface ShoeSoleService extends
        BasicCRUDService<ShoeSole>, BasicSearchMaterialMethods<ShoeSole>, ShoeSoleSearchMethods {
}
