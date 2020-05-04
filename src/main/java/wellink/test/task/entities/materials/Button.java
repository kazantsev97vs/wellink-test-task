package wellink.test.task.entities.materials;

import wellink.test.task.enums.Color;
import wellink.test.task.models.Material;
import javax.persistence.Entity;

/**
 * Материал: "пуговица"
 */
@Entity
public class Button extends Material {

    public Button(Long id, String name, Double price, Color color) {
        super(id, name, price, color);
    }

    public Button(String name, Double price, Color color) {
        super(name, price, color);
    }

    public Button() {
    }

    @Override
    public String toString() {
        return "Button{" + super.toString() + '}';
    }
}
