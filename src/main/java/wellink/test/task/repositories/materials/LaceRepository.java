package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.materials.Lace;
import wellink.test.task.enums.Color;
import wellink.test.task.enums.Density;

import java.util.List;

public interface LaceRepository extends CrudRepository<Lace, Long> {

    List<Lace> getAllByName(String name);

    List<Lace> getAllByPrice(Double price);

    List<Lace> getAllByColor(Color color);

    List<Lace> getAllByLength(Integer length);

    List<Lace> getAllByDensity(Density density);

}
