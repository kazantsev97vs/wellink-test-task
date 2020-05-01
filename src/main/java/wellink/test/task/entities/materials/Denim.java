package wellink.test.task.entities.materials;

import wellink.test.task.models.Material;
import javax.persistence.Entity;

/**
 * Материал: "джинсовая ткань"
 */
@Entity
public class Denim extends Material {
    public static Type type = Type.DENIM;
}
