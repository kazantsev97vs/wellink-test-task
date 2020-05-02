package wellink.test.task.repositories.materials;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.materials.ShoeSole;
import wellink.test.task.enums.Color;

import java.util.List;

public interface ShoeSoleRepository extends CrudRepository<ShoeSole, Long> {

    List<ShoeSole> getAllByName(String name);

    List<ShoeSole> getAllByPrice(Double price);

    List<ShoeSole> getAllByColor(Color color);

    List<ShoeSole> getAllByThickness(ShoeSole.SoleThickness thickness);
}
