package wellink.test.task.repositories.products;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.products.DenimSneakers;
import wellink.test.task.interfaces.BasicSearchClothesMethods;
import wellink.test.task.interfaces.productsSearch.DenimSneakersSearchMethods;

@Repository
public interface DenimSneakersRepository extends
        CrudRepository<DenimSneakers, Long>, BasicSearchClothesMethods<DenimSneakers>, DenimSneakersSearchMethods {
}
