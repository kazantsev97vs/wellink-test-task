package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.materials.ShoeSole;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;
import wellink.test.task.interfaces.materialsSearch.ShoeSoleSearchMethods;

@Repository
public interface ShoeSoleRepository extends
        CrudRepository<ShoeSole, Long>, BasicSearchMaterialMethods<ShoeSole>, ShoeSoleSearchMethods {
}
