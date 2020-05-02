package wellink.test.task.repositories.products;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.products.DenimPants;
import wellink.test.task.enums.*;

import java.util.List;

public interface DenimPantsRepository extends CrudRepository<DenimPants, Long> {

    // Material
    List<DenimPants> getAllByName(String name);

    List<DenimPants> getAllByPrice(Double price);

    List<DenimPants> getAllByColor(Color color);

    // Clothes
    List<DenimPants> findAllBySize(Size size);

    List<DenimPants> findAllByDensity(Density density);

    List<DenimPants> findAllByForWhatGender(Gender gender);

    List<DenimPants> findAllByForWhatAge(Age age);

    // DenimPants
    List<DenimPants> findAllByIsSkinny(Boolean isSkinny);

    List<DenimPants> findAllByIsStretch(Boolean isStretch);

    List<DenimPants> findAllByClosureType(ClosureType type);

    List<DenimPants> findAllByIsInsulated(Boolean isInsulated);
}