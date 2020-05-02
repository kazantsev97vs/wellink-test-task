package wellink.test.task.repositories.products;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.products.DenimPants;

public interface DenimPantsRepository extends CrudRepository <DenimPants, Long> {
}
