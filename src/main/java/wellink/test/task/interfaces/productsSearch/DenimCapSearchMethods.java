package wellink.test.task.interfaces.productsSearch;

import wellink.test.task.entities.products.DenimCap;
import java.util.List;

public interface DenimCapSearchMethods {

    List<DenimCap> findAllByCapType(DenimCap.CapType type);

    List<DenimCap> findAllByVisorLength(Integer length);

    List<DenimCap> findAllByHasCapSizeAdjustment(Boolean hasCapSizeAdjustment);

}
