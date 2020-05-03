package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.materials.Denim;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;
import wellink.test.task.interfaces.materialsSearch.DenimSearchMethods;

@Repository
public interface DenimRepository extends
        CrudRepository <Denim, Long>, BasicSearchMaterialMethods<Denim>, DenimSearchMethods {
}
