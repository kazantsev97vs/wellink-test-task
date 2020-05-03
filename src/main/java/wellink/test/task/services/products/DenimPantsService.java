package wellink.test.task.services.products;

import wellink.test.task.entities.products.DenimPants;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.BasicSearchClothesMethods;
import wellink.test.task.interfaces.productsSearch.DenimPantsSearchMethods;


/**
 * CRUD-сервис для работы с продуктом "Джинсовые штаны"
 */
public interface DenimPantsService extends
        BasicCRUDService<DenimPants>, BasicSearchClothesMethods<DenimPants>, DenimPantsSearchMethods {
}
