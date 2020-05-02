package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.materials.Denim;
import wellink.test.task.enums.Color;
import wellink.test.task.enums.Density;

import java.util.List;

public interface DenimRepository extends CrudRepository <Denim, Long> {

    List<Denim> getAllByName(String name);

    List<Denim> getAllByPrice(Double price);

    List<Denim> getAllByColor(Color color);

    List<Denim> getAllByDensity(Density density);
}
