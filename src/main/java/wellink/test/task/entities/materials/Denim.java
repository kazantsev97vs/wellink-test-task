package wellink.test.task.entities.materials;

import lombok.Data;
import wellink.test.task.enums.Color;
import wellink.test.task.enums.Density;
import wellink.test.task.enums.Stiffness;
import wellink.test.task.models.Material;

import javax.persistence.Entity;

/**
 * Материал: "джинсовая ткань"
 */
@Entity
@Data
public class Denim extends Material {

    private Density density;

    private Stiffness stiffness;

    public Denim(String name, Double price, Color color) {
        super(name, price, color);
    }

    public Denim(String name, Double price, Color color, Density density, Stiffness stiffness) {
        super(name, price, color);
        this.density = density;
        this.stiffness = stiffness;
    }

    public Denim(Density density, Stiffness stiffness) {
        this.density = density;
        this.stiffness = stiffness;
    }

    public Denim() {
    }

    @Override
    public String toString() {
        return "Denim{"
                + super.toString()
                + ", density=" + density
                + ", stiffness=" + stiffness
                + '}';
    }
}
