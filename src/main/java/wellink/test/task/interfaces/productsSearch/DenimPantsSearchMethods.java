package wellink.test.task.interfaces.productsSearch;

import wellink.test.task.entities.products.DenimPants;
import wellink.test.task.enums.ClosureType;

import java.util.List;

public interface DenimPantsSearchMethods {

    List<DenimPants> findAllByIsSkinny(Boolean isSkinny);

    List<DenimPants> findAllByIsStretch(Boolean isStretch);

    List<DenimPants> findAllByClosureType(ClosureType type);

    List<DenimPants> findAllByIsInsulated(Boolean isInsulated);

}
