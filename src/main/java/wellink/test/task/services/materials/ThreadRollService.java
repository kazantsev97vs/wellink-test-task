package wellink.test.task.services.materials;

import wellink.test.task.entities.materials.ThreadRoll;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;
import wellink.test.task.interfaces.materialsSearch.ThreadRollSearchMethods;


/**
 * CRUD-сервис для работы с материалом "рулон ниток"
 */
public interface ThreadRollService extends
        BasicCRUDService<ThreadRoll>, BasicSearchMaterialMethods<ThreadRoll>, ThreadRollSearchMethods {
}
