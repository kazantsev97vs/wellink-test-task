package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.materials.Lock;
import wellink.test.task.enums.Color;

import java.util.List;

public interface LockRepository extends CrudRepository<Lock, Long> {

    List<Lock> getAllByName(String name);

    List<Lock> getAllByPrice(Double price);

    List<Lock> getAllByColor(Color color);
}
