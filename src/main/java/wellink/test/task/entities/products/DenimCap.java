package wellink.test.task.entities.products;

import lombok.Data;
import lombok.NoArgsConstructor;
import wellink.test.task.enums.*;
import wellink.test.task.models.Clothes;
import javax.persistence.Entity;

/**
 * Джинсовая кепка
 */
@Entity
@Data
public class DenimCap extends Clothes {

    /**
     * длина козырька (в см)
     */
    private Integer visorLength;

    /**
     * тип кепки
     */
    private CapType capType;

    /**
     * Есть ли у кепки регулировка размера
     */
    private Boolean hasCapSizeAdjustment;

    public DenimCap(Integer id, String name, Double price, Color color) {
        super(id, name, price, color);
    }

    public DenimCap(Integer id, String name, Double price, Color color, Size size, Density density, Gender forWhatGender, Age forWhatAge) {
        super(id, name, price, color, size, density, forWhatGender, forWhatAge);
    }

    public DenimCap(Integer id, String name, Double price, Color color, Integer visorLength, CapType capType, Boolean hasCapSizeAdjustment) {
        super(id, name, price, color);
        this.visorLength = visorLength;
        this.capType = capType;
        this.hasCapSizeAdjustment = hasCapSizeAdjustment;
    }

    public DenimCap(Integer id, String name, Double price, Color color, Size size, Density density, Gender forWhatGender, Age forWhatAge, Integer visorLength, CapType capType, Boolean hasCapSizeAdjustment) {
        super(id, name, price, color, size, density, forWhatGender, forWhatAge);
        this.visorLength = visorLength;
        this.capType = capType;
        this.hasCapSizeAdjustment = hasCapSizeAdjustment;
    }

    public DenimCap(Integer visorLength, CapType capType, Boolean hasCapSizeAdjustment) {
        this.visorLength = visorLength;
        this.capType = capType;
        this.hasCapSizeAdjustment = hasCapSizeAdjustment;
    }

    public DenimCap() {
    }

    /**
     * Тип кепки
     */
    public enum  CapType {
        EIGHTH_GRADER,  //  кепка восьмиклинка
        RAGLAN,         //  кепка картуз
        GERMAN,         //  кепка реглан
        DUCK,           //  кепка немка
        TRACKER,        //  кепка уточка
        BUNNET,         //  кепка-тракер
        BASEBALL,       //  кепка буннет
        BICYCLE         //  кепка бейсболка
    }
}