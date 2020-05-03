package wellink.test.task.services.products;

import wellink.test.task.entities.products.DenimJacket;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.BasicSearchClothesMethods;
import wellink.test.task.interfaces.productsSearch.DenimJacketSearchMethods;


/**
 * CRUD-сервис для работы с продуктом "Джинсовая куртка"
 */
public interface DenimJacketService extends
        BasicCRUDService<DenimJacket>, BasicSearchClothesMethods<DenimJacket>, DenimJacketSearchMethods {
}
