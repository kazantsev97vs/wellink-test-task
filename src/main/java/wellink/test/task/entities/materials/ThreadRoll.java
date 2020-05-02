package wellink.test.task.entities.materials;

import lombok.Data;
import wellink.test.task.enums.Color;
import wellink.test.task.enums.Density;
import wellink.test.task.models.Material;
import javax.persistence.Entity;


/**
 * Материал: "рулон ниток"
 */
@Entity
@Data
public class ThreadRoll extends Material {

    private Density threadDensity;

    public ThreadRoll(Integer id, String name, Double price, Color color) {
        super(id, name, price, color);
    }

    public ThreadRoll(Integer id, String name, Double price, Color color, Density threadDensity) {
        super(id, name, price, color);
        this.threadDensity = threadDensity;
    }

    public ThreadRoll() {
    }
}
