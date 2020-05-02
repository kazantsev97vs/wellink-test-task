package wellink.test.task.services.materials;

import wellink.test.task.entities.materials.Button;
import wellink.test.task.enums.Color;

import java.util.List;

/**
 * CRUD-сервис для работы с материалом "пуговица"
 */
public interface ButtonService {

    Button save(Button button);

    Button getById(Long id);

    List<Button> getAll();

    List<Button> getAllByName(String name);

    List<Button> getAllByPrice(Double price);

    List<Button> getAllByColor(Color color);

    Button update(Button button);

    Boolean deleteById(Long id);

    Boolean delete(Button button);
}
