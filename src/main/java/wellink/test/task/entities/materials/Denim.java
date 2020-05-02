package wellink.test.task.entities.materials;

import lombok.Data;
import wellink.test.task.enums.Color;
import wellink.test.task.enums.Density;
import wellink.test.task.models.Material;
import javax.persistence.Entity;

/**
 * Материал: "джинсовая ткань"
 */
@Entity
@Data
public class Denim extends Material {

    private Density density;

    public Denim(Integer id, String name, Double price, Color color) {
        super(id, name, price, color);
    }

    public Denim(Integer id, String name, Double price, Color color, Density density) {
        super(id, name, price, color);
        this.density = density;
    }

    public Denim() {
    }
}
