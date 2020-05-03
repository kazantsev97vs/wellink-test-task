package wellink.test.task.interfaces.productsSearch;

import wellink.test.task.entities.products.DenimJacket;
import wellink.test.task.enums.ClosureType;

import java.util.List;

public interface DenimJacketSearchMethods {

    List<DenimJacket> findAllByHasHood(Boolean hasHood);

    List<DenimJacket> findAllByPocketsNumber(Integer pocketsNumber);

    List<DenimJacket> findAllBySleeveLength(Integer sleeveLength);

    List<DenimJacket> findAllByIsInsulated(Boolean isInsulated);

    List<DenimJacket> findAllByClosureType(ClosureType type);

}
