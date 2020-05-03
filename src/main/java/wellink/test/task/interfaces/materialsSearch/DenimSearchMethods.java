package wellink.test.task.interfaces.materialsSearch;

import wellink.test.task.entities.materials.Denim;
import wellink.test.task.enums.Density;

import java.util.List;

public interface DenimSearchMethods {

    List<Denim> getAllByDensity(Density density);

}
