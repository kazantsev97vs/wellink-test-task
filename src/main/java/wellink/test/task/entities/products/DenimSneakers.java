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

    private Stiffness stiffness;

    public DenimSneakers() {
    }

    public DenimSneakers(String name, Double price, Color color) {
        super(name, price, color);
    }

    public DenimSneakers(String name, Double price, Color color, Size size,
                         Density density, Gender forWhatGender, Age forWhatAge) {
        super(name, price, color, size, density, forWhatGender, forWhatAge);
    }

    public DenimSneakers(ClosureType closureType, ShoeSole.SoleThickness soleThickness,
                         Boolean isInsulated, Stiffness stiffness) {
        this.closureType = closureType;
        this.soleThickness = soleThickness;
        this.isInsulated = isInsulated;
        this.stiffness = stiffness;
    }

    public DenimSneakers(String name, Double price, Color color, ClosureType closureType,
                         ShoeSole.SoleThickness soleThickness, Boolean isInsulated, Stiffness stiffness) {
        super(name, price, color);
        this.closureType = closureType;
        this.soleThickness = soleThickness;
        this.isInsulated = isInsulated;
        this.stiffness = stiffness;
    }

    public DenimSneakers(String name, Double price, Color color, Size size, Density density,
                         Gender forWhatGender, Age forWhatAge, ClosureType closureType,
                         ShoeSole.SoleThickness soleThickness, Boolean isInsulated, Stiffness stiffness) {
        super(name, price, color, size, density, forWhatGender, forWhatAge);
        this.closureType = closureType;
        this.soleThickness = soleThickness;
        this.isInsulated = isInsulated;
        this.stiffness = stiffness;
    }

    @Override
    public String toString() {
        return "DenimSneakers{"
                + super.toString()
                + ", closureType=" + closureType
                + ", soleThickness=" + soleThickness
                + ", isInsulated=" + isInsulated
                + '}';
    }
}
