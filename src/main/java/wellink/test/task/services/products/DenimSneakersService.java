package wellink.test.task.services.products;

import wellink.test.task.entities.products.DenimSneakers;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.BasicSearchClothesMethods;
import wellink.test.task.interfaces.productsSearch.DenimSneakersSearchMethods;


/**
 * CRUD-сервис для работы с продуктом "Джинсовые кроссовки"
 */
public interface DenimSneakersService extends
        BasicCRUDService<DenimSneakers>, BasicSearchClothesMethods<DenimSneakers>, DenimSneakersSearchMethods {
}
