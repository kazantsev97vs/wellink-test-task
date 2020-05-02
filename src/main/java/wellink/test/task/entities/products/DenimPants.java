package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import wellink.test.task.enums.*;
import wellink.test.task.models.Clothes;
import javax.persistence.Entity;

/**
 * Джинсовые штаны
 */
@Entity
public class DenimPants extends Clothes {

    /**
     * Зауженные штаны
     */
    private Boolean isSkinny;

    /**
     * тянущаяся ткань
     */
    private Boolean isStretch;

    private ClosureType closureType;

    private Boolean isInsulated;

    public DenimPants() {
    }

    public DenimPants(Integer id, String name, Double price, Color color) {
        super(id, name, price, color);
    }

    public DenimPants(Integer id, String name, Double price, Color color, Size size, Density density, Gender forWhatGender, Age forWhatAge) {
        super(id, name, price, color, size, density, forWhatGender, forWhatAge);
    }

    public DenimPants(Boolean isSkinny, Boolean isStretch, ClosureType closureType, Boolean isInsulated) {
        this.isSkinny = isSkinny;
        this.isStretch = isStretch;
        this.closureType = closureType;
        this.isInsulated = isInsulated;
    }

    public DenimPants(Integer id, String name, Double price, Color color, Boolean isSkinny, Boolean isStretch, ClosureType closureType, Boolean isInsulated) {
        super(id, name, price, color);
        this.isSkinny = isSkinny;
        this.isStretch = isStretch;
        this.closureType = closureType;
        this.isInsulated = isInsulated;
    }

    public DenimPants(Integer id, String name, Double price, Color color, Size size, Density density, Gender forWhatGender, Age forWhatAge, Boolean isSkinny, Boolean isStretch, ClosureType closureType, Boolean isInsulated) {
        super(id, name, price, color, size, density, forWhatGender, forWhatAge);
        this.isSkinny = isSkinny;
        this.isStretch = isStretch;
        this.closureType = closureType;
        this.isInsulated = isInsulated;
    }
}
