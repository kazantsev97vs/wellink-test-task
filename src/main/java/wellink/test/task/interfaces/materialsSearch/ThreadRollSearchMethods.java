package wellink.test.task.interfaces.materialsSearch;

import wellink.test.task.entities.materials.ThreadRoll;
import wellink.test.task.enums.Density;

import java.util.List;

public interface ThreadRollSearchMethods {

    List<ThreadRoll> getAllByThreadDensity(Density density);

    List<ThreadRoll> getAllByThreadLength(Integer length);

}
