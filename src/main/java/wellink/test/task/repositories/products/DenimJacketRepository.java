package wellink.test.task.repositories.products;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.products.DenimJacket;
import wellink.test.task.enums.*;

import java.util.List;

public interface DenimJacketRepository extends CrudRepository<DenimJacket, Long> {

    // Material
    List<DenimJacket> getAllByName(String name);

    List<DenimJacket> getAllByPrice(Double price);

    List<DenimJacket> getAllByColor(Color color);

    // Clothes
    List<DenimJacket> findAllBySize(Size size);

    List<DenimJacket> findAllByDensity(Density density);

    List<DenimJacket> findAllByForWhatGender(Gender gender);

    List<DenimJacket> findAllByForWhatAge(Age age);

    // DenimJacket
    List<DenimJacket> findAllByHasHood(Boolean hasHood);

    List<DenimJacket> findAllByPocketsNumber(Integer pocketsNumber);

    List<DenimJacket> findAllBySleeveLength(Integer sleeveLength);

    List<DenimJacket> findAllByIsInsulated(Boolean isInsulated);

    List<DenimJacket> findAllByClosureType(ClosureType type);

}