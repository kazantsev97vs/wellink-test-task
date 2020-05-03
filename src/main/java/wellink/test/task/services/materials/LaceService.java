package wellink.test.task.services.materials;

import wellink.test.task.entities.materials.Lace;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;
import wellink.test.task.interfaces.materialsSearch.LaceSearchMethods;


/**
 * CRUD-сервис для работы с материалом "шнурок"
 */
public interface LaceService extends
        BasicCRUDService<Lace>, BasicSearchMaterialMethods<Lace>, LaceSearchMethods {
}
