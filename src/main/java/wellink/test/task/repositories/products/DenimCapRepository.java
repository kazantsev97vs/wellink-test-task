package wellink.test.task.repositories.products;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.products.DenimCap;
import wellink.test.task.interfaces.BasicSearchClothesMethods;
import wellink.test.task.interfaces.productsSearch.DenimCapSearchMethods;

@Repository
public interface DenimCapRepository extends
        CrudRepository<DenimCap, Long>, BasicSearchClothesMethods<DenimCap>, DenimCapSearchMethods {
}