package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.materials.Button;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;

@Repository
public interface ButtonRepository extends
        CrudRepository <Button, Long>, BasicSearchMaterialMethods<Button> {
}
