package wellink.test.task.services.impl.materials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.materials.Button;
import wellink.test.task.enums.Color;
import wellink.test.task.repositories.materials.ButtonRepository;
import wellink.test.task.services.materials.ButtonService;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с материалом "пуговица"
 */
@Service
public class ButtonServiceImpl implements ButtonService {

    @Autowired
    private ButtonRepository buttonRepository;

    @Override
    public Button save(Button button) {
        return buttonRepository.save(button);
    }

    @Override
    public Button getById(Long id) {
        return buttonRepository.findById(id).orElse(null);
    }

    @Override
    public List<Button> getAll() {
        List<Button> buttonList = new ArrayList<>();

        buttonRepository.findAll().forEach(buttonList::add);

        return buttonList;
    }

    @Override
    public List<Button> getAllByName(String name) {
        return buttonRepository.getAllByName(name);
    }

    @Override
    public List<Button> getAllByPrice(Double price) {
        return buttonRepository.getAllByPrice(price);
    }

    @Override
    public List<Button> getAllByColor(Color color) {
        return buttonRepository.getAllByColor(color);
    }

    @Override
    public Button update(Button button) {
        if (getById(button.getId()) == null) return null;

        return buttonRepository.save(button);
    }

    @Override
    public Boolean deleteById(Long id) {
        buttonRepository.deleteById(id);
        return getById(id) == null;
    }

    @Override
    public Boolean delete(Button button) {
        buttonRepository.delete(button);
        return getById(button.getId()) == null;
    }
}
