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

    private Integer threadLength;

    public ThreadRoll(String name, Double price, Color color) {
        super(name, price, color);
    }

    public ThreadRoll(String name, Double price, Color color, Density threadDensity, Integer threadLength) {
        super(name, price, color);
        this.threadDensity = threadDensity;
        this.threadLength = threadLength;
    }

    public ThreadRoll(Density threadDensity, Integer threadLength) {
        this.threadDensity = threadDensity;
        this.threadLength = threadLength;
    }

    public ThreadRoll() {
    }

    @Override
    public String toString() {
        return "ThreadRoll{"
                + super.toString()
                + "threadDensity=" + threadDensity
                + ", threadLength=" + threadLength
                + '}';
    }
}
