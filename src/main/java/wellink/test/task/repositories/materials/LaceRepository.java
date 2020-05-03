package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.materials.Lace;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;
import wellink.test.task.interfaces.materialsSearch.LaceSearchMethods;

@Repository
public interface LaceRepository extends
        CrudRepository<Lace, Long>, BasicSearchMaterialMethods<Lace>, LaceSearchMethods {
}
