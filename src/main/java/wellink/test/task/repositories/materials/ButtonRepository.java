package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.materials.Button;
import wellink.test.task.enums.Color;

import java.util.List;

public interface ButtonRepository extends CrudRepository <Button, Long> {

    List<Button> getAllByName(String name);

    List<Button> getAllByPrice(Double price);

    List<Button> getAllByColor(Color color);

}
