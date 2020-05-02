package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.materials.Button;

public interface ButtonRepository extends CrudRepository <Button, Long> {
}
