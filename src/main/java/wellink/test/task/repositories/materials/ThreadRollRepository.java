package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.materials.ThreadRoll;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;
import wellink.test.task.interfaces.materialsSearch.ThreadRollSearchMethods;

@Repository
public interface ThreadRollRepository extends
        CrudRepository<ThreadRoll, Long>, BasicSearchMaterialMethods<ThreadRoll>, ThreadRollSearchMethods {
}
