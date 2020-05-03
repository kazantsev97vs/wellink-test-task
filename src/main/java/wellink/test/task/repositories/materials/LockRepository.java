package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.materials.Lock;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;

@Repository
public interface LockRepository extends
        CrudRepository<Lock, Long>, BasicSearchMaterialMethods<Lock> {
}
