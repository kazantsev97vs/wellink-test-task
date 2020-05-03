package wellink.test.task.repositories.products;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.products.DenimPants;
import wellink.test.task.interfaces.BasicSearchClothesMethods;
import wellink.test.task.interfaces.productsSearch.DenimPantsSearchMethods;

@Repository
public interface DenimPantsRepository extends
        CrudRepository<DenimPants, Long>, BasicSearchClothesMethods<DenimPants>, DenimPantsSearchMethods {
}