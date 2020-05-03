package wellink.test.task.interfaces.productsSearch;

import wellink.test.task.entities.materials.ShoeSole;
import wellink.test.task.entities.products.DenimSneakers;
import wellink.test.task.enums.ClosureType;

import java.util.List;

public interface DenimSneakersSearchMethods {

    List<DenimSneakers> findAllByClosureType(ClosureType closureType);

    List<DenimSneakers> findAllBySoleThickness(ShoeSole.SoleThickness thickness);

    List<DenimSneakers> findAllByIsInsulated(Boolean isInsulated);

}
