package wellink.test.task.entities.materials;

import lombok.Data;
import wellink.test.task.enums.Color;
import wellink.test.task.models.Material;
import javax.persistence.Entity;

/**
 * Материал: "подошва для обуви"
 */
@Entity
@Data
public class ShoeSole extends Material {

    private SoleThickness thickness;

    public ShoeSole(String name, Double price, Color color) {
        super(name, price, color);
    }

    public ShoeSole(String name, Double price, Color color, SoleThickness thickness) {
        super(name, price, color);
        this.thickness = thickness;
    }

    public ShoeSole(SoleThickness thickness) {
        this.thickness = thickness;
    }

    public ShoeSole() {
    }

    /**
     * толщина подошвы
     */
    public enum SoleThickness {
        THICK,  // толстая
        THIN,   // тонкая
        AVERAGE // средняя
    }

    @Override
    public String toString() {
        return "ShoeSole{"
                + super.toString()
                + ", thickness=" + thickness
                + '}';
    }
}
