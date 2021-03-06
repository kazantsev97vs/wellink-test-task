package wellink.test.task.entities.materials;

import wellink.test.task.enums.Color;
import wellink.test.task.models.Material;
import javax.persistence.Entity;

/**
 * Материал: "замок"
 */
@Entity
public class Lock extends Material {

    public Lock(String name, Double price, Color color) {
        super(name, price, color);
    }

    public Lock() {
    }

    @Override
    public String toString() {
        return "Lock{" + super.toString() + '}';
    }
}
