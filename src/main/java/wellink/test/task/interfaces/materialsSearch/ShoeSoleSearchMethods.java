package wellink.test.task.interfaces.materialsSearch;

import wellink.test.task.entities.materials.ShoeSole;
import java.util.List;

public interface ShoeSoleSearchMethods {

    List<ShoeSole> getAllByThickness(ShoeSole.SoleThickness thickness);
}
