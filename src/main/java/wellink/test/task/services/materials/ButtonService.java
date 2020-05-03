package wellink.test.task.services.materials;

import wellink.test.task.entities.materials.Button;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.BasicSearchMaterialMethods;


/**
 * CRUD-сервис для работы с материалом "пуговица"
 */
public interface ButtonService extends
        BasicCRUDService<Button>, BasicSearchMaterialMethods<Button> {
}
