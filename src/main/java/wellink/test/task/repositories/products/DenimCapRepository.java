package wellink.test.task.repositories.products;

import org.springframework.data.repository.CrudRepository;
import wellink.test.task.entities.products.DenimCap;
import wellink.test.task.enums.*;

import java.util.List;

public interface DenimCapRepository extends CrudRepository<DenimCap, Long> {

    // Material
    List<DenimCap> getAllByName(String name);

    List<DenimCap> getAllByPrice(Double price);

    List<DenimCap> getAllByColor(Color color);

    // Clothes
    List<DenimCap> findAllBySize(Size size);

    List<DenimCap> findAllByDensity(Density density);

    List<DenimCap> findAllByForWhatGender(Gender gender);

    List<DenimCap> findAllByForWhatAge(Age age);

    // DenimCap
    List<DenimCap> findAllByCapType(DenimCap.CapType type);

    List<DenimCap> findAllByVisorLength(Integer length);

    List<DenimCap> findAllByHasCapSizeAdjustment(Boolean hasCapSizeAdjustment);
}