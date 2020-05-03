package wellink.test.task.services.products;

import wellink.test.task.entities.products.DenimCap;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.BasicSearchClothesMethods;
import wellink.test.task.interfaces.materialsSearch.DenimSearchMethods;


/**
 * CRUD-сервис для работы с продуктом "Джинсовая кепка"
 */
public interface DenimCapService extends
        BasicCRUDService<DenimCap>, BasicSearchClothesMethods<DenimCap>, DenimSearchMethods {
}
