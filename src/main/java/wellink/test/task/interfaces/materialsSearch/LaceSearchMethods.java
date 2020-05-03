package wellink.test.task.interfaces.materialsSearch;

import wellink.test.task.entities.materials.Lace;
import wellink.test.task.enums.Density;

import java.util.List;

public interface LaceSearchMethods {

    List<Lace> getAllByLength(Integer length);

    List<Lace> getAllByDensity(Density density);

}
