package wellink.test.task.entities.products;

import wellink.test.task.enums.*;
import wellink.test.task.models.Clothes;
import javax.persistence.Entity;

/**
 * Джинсовые штаны
 */
@Entity
public class DenimPants extends Clothes {

    /**
     * Количество карманов
     */
    private Integer pocketsNumber;

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

    public DenimPants(String name, Double price, Color color) {
        super(name, price, color);
    }

    public DenimPants(String name, Double price, Color color, Size size,
                      Density density, Gender forWhatGender, Age forWhatAge) {
        super(name, price, color, size, density, forWhatGender, forWhatAge);
    }

    public DenimPants(Integer pocketsNumber, Boolean isSkinny, Boolean isStretch,
                      ClosureType closureType, Boolean isInsulated) {
        this.pocketsNumber = pocketsNumber;
        this.isSkinny = isSkinny;
        this.isStretch = isStretch;
        this.closureType = closureType;
        this.isInsulated = isInsulated;
    }

    public DenimPants(String name, Double price, Color color, Integer pocketsNumber,
                      Boolean isSkinny, Boolean isStretch, ClosureType closureType, Boolean isInsulated) {
        super(name, price, color);
        this.pocketsNumber = pocketsNumber;
        this.isSkinny = isSkinny;
        this.isStretch = isStretch;
        this.closureType = closureType;
        this.isInsulated = isInsulated;
    }

    public DenimPants(String name, Double price, Color color, Size size, Density density,
                      Gender forWhatGender, Age forWhatAge, Integer pocketsNumber, Boolean isSkinny,
                      Boolean isStretch, ClosureType closureType, Boolean isInsulated) {
        super(name, price, color, size, density, forWhatGender, forWhatAge);
        this.pocketsNumber = pocketsNumber;
        this.isSkinny = isSkinny;
        this.isStretch = isStretch;
        this.closureType = closureType;
        this.isInsulated = isInsulated;
    }

    @Override
    public String toString() {
        return "DenimPants{"
                + super.toString()
                + ", isSkinny=" + isSkinny
                + ", isStretch=" + isStretch
                + ", closureType=" + closureType
                + ", isInsulated=" + isInsulated
                + '}';
    }
}
