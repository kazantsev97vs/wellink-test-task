package wellink.test.task.repositories.products;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.products.DenimJacket;
import wellink.test.task.interfaces.BasicSearchClothesMethods;
import wellink.test.task.interfaces.productsSearch.DenimJacketSearchMethods;

@Repository
public interface DenimJacketRepository extends
        CrudRepository<DenimJacket, Long>, BasicSearchClothesMethods<DenimJacket>, DenimJacketSearchMethods {
}