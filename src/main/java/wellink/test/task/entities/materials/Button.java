package wellink.test.task.entities.materials;

import wellink.test.task.models.Material;
import javax.persistence.Entity;

/**
 * Материал: "пуговица"
 */
@Entity
public class Button extends Material {

    public static Type type = Type.BUTTONS;
}
