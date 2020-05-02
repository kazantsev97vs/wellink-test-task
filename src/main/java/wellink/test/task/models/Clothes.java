package wellink.test.task.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import wellink.test.task.enums.*;
import javax.persistence.MappedSuperclass;

/**
 * Одежда
 */
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class Clothes extends Material {

    private Size size;

    private Density density;

    private Gender forWhatGender;

    private Age forWhatAge;

    public Clothes(Long id, String name, Double price, Color color) {
        super(id, name, price, color);
    }

    public Clothes(Long id, String name, Double price, Color color, Size size, Density density, Gender forWhatGender, Age forWhatAge) {
        super(id, name, price, color);
        this.size = size;
        this.density = density;
        this.forWhatGender = forWhatGender;
        this.forWhatAge = forWhatAge;
    }
}
