package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.materials.Lock;

public interface LockRepository extends CrudRepository <Lock, Integer> {
}
