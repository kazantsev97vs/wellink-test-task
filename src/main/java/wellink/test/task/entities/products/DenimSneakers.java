package wellink.test.task.entities.products;

import lombok.Data;
import wellink.test.task.entities.materials.ShoeSole;
import wellink.test.task.enums.*;
import wellink.test.task.models.Clothes;
import javax.persistence.Entity;

/**
 * Джинсовые кроссовки
 */
@Entity
@Data
public class DenimSneakers extends Clothes {

    private ClosureType closureType;

    private ShoeSole.SoleThickness soleThickness;

    private Boolean isInsulated;

    public DenimSneakers() {
    }

    public DenimSneakers(Long id, String name, Double price, Color color) {
        super(id, name, price, color);
    }

    public DenimSneakers(Long id, String name, Double price, Color color, Size size, Density density, Gender forWhatGender, Age forWhatAge) {
        super(id, name, price, color, size, density, forWhatGender, forWhatAge);
    }

    public DenimSneakers(ClosureType closureType, ShoeSole.SoleThickness soleThickness, Boolean isInsulated) {
        this.closureType = closureType;
        this.soleThickness = soleThickness;
        this.isInsulated = isInsulated;
    }

    public DenimSneakers(Long id, String name, Double price, Color color, ClosureType closureType, ShoeSole.SoleThickness soleThickness, Boolean isInsulated) {
        super(id, name, price, color);
        this.closureType = closureType;
        this.soleThickness = soleThickness;
        this.isInsulated = isInsulated;
    }

    public DenimSneakers(Long id, String name, Double price, Color color, Size size, Density density, Gender forWhatGender, Age forWhatAge, ClosureType closureType, ShoeSole.SoleThickness soleThickness, Boolean isInsulated) {
        super(id, name, price, color, size, density, forWhatGender, forWhatAge);
        this.closureType = closureType;
        this.soleThickness = soleThickness;
        this.isInsulated = isInsulated;
    }
}
