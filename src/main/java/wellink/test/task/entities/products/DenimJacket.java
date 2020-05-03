package wellink.test.task.entities.products;

import lombok.Data;
import wellink.test.task.enums.*;
import wellink.test.task.models.Clothes;

import javax.persistence.Entity;

/**
 * Джинсовая куртка
 */
@Entity
@Data
public class DenimJacket extends Clothes {

    /**
     * С капюшоном куртка или нет
     */
    private Boolean hasHood;

    /**
     * Количество карманов
     */
    private Integer pocketsNumber;

    /**
     * длина рукава (см)
     */
    private Integer sleeveLength;

    /**
     * Утепленная куртка или нет
     */
    private Boolean isInsulated;

    private ClosureType closureType;

    public DenimJacket() {
    }

    public DenimJacket(Long id, String name, Double price, Color color) {
        super(id, name, price, color);
    }

    public DenimJacket(Long id, String name, Double price, Color color, Size size,
                       Density density, Gender forWhatGender, Age forWhatAge) {
        super(id, name, price, color, size, density, forWhatGender, forWhatAge);
    }

    public DenimJacket(Boolean hasHood, Integer pocketsNumber, Integer sleeveLength,
                       Boolean isInsulated, ClosureType closureType) {
        this.hasHood = hasHood;
        this.pocketsNumber = pocketsNumber;
        this.sleeveLength = sleeveLength;
        this.isInsulated = isInsulated;
        this.closureType = closureType;
    }

    public DenimJacket(Long id, String name, Double price, Color color, Boolean hasHood, Integer pocketsNumber,
                       Integer sleeveLength, Boolean isInsulated, ClosureType closureType) {
        super(id, name, price, color);
        this.hasHood = hasHood;
        this.pocketsNumber = pocketsNumber;
        this.sleeveLength = sleeveLength;
        this.isInsulated = isInsulated;
        this.closureType = closureType;
    }

    public DenimJacket(Long id, String name, Double price, Color color, Size size, Density density,
                       Gender forWhatGender, Age forWhatAge, Boolean hasHood, Integer pocketsNumber,
                       Integer sleeveLength, Boolean isInsulated, ClosureType closureType) {
        super(id, name, price, color, size, density, forWhatGender, forWhatAge);
        this.hasHood = hasHood;
        this.pocketsNumber = pocketsNumber;
        this.sleeveLength = sleeveLength;
        this.isInsulated = isInsulated;
        this.closureType = closureType;
    }

    @Override
    public String toString() {
        return "DenimJacket{"
                + super.toString()
                + ", hasHood=" + hasHood
                + ", pocketsNumber=" + pocketsNumber
                + ", sleeveLength=" + sleeveLength
                + ", isInsulated=" + isInsulated
                + ", closureType=" + closureType
                + '}';
    }
}
