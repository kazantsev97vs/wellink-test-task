package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.materials.ThreadRoll;
import wellink.test.task.enums.Color;
import wellink.test.task.enums.Density;

import java.util.List;

public interface ThreadRollRepository extends CrudRepository<ThreadRoll, Long> {

    List<ThreadRoll> getAllByName(String name);

    List<ThreadRoll> getAllByPrice(Double price);

    List<ThreadRoll> getAllByColor(Color color);

    List<ThreadRoll> getAllByThreadDensity(Density density);

    List<ThreadRoll> getAllByThreadLength(Integer length);

}
