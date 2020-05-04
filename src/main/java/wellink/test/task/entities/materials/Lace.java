package wellink.test.task.entities.materials;

import lombok.Data;
import wellink.test.task.enums.Color;
import wellink.test.task.enums.Density;
import wellink.test.task.models.Material;
import javax.persistence.Entity;

/**
 * Материал: "шнурок"
 */
@Entity
@Data
public class Lace extends Material {

    private Integer length;

    private Density density;

    public Lace(String name, Double price, Color color) {
        super(name, price, color);
    }

    public Lace(String name, Double price, Color color, Integer length, Density density) {
        super(name, price, color);
        this.length = length;
        this.density = density;
    }

    public Lace(Integer length, Density density) {
        this.length = length;
        this.density = density;
    }

    public Lace() {
    }

    @Override
    public String toString() {
        return "Lace{"
                + super.toString()
                + ", length=" + length
                + ", density=" + density
                + '}';
    }

}
