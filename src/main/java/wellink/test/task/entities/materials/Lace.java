package wellink.test.task.entities.materials;

import lombok.Data;
import wellink.test.task.enums.Color;
import wellink.test.task.models.Material;
import javax.persistence.Entity;

/**
 * Материал: "шнурок"
 */
@Entity
@Data
public class Lace extends Material {
    private Integer length;

    public Lace(Long id, String name, Double price, Color color) {
        super(id, name, price, color);
    }

    public Lace(String name, Double price, Color color, Integer length) {
        super(null, name, price, color);
        this.length = length;
    }

    public Lace() {
    }

}
