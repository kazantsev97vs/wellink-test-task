package wellink.test.task.repositories.products;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.materials.ShoeSole;
import wellink.test.task.entities.products.DenimSneakers;
import wellink.test.task.enums.*;

import java.util.List;

public interface DenimSneakersRepository extends CrudRepository<DenimSneakers, Long> {

    // Material
    List<DenimSneakers> getAllByName(String name);

    List<DenimSneakers> getAllByPrice(Double price);

    List<DenimSneakers> getAllByColor(Color color);

    // Clothes
    List<DenimSneakers> findAllBySize(Size size);

    List<DenimSneakers> findAllByDensity(Density density);

    List<DenimSneakers> findAllByForWhatGender(Gender gender);

    List<DenimSneakers> findAllByForWhatAge(Age age);

    // DenimSneakers
    List<DenimSneakers> findAllByClosureType(ClosureType closureType);

    List<DenimSneakers> findAllBySoleThickness(ShoeSole.SoleThickness thickness);

    List<DenimSneakers> findAllByIsInsulated(Boolean isInsulated);
}
