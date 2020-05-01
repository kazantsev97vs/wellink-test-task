package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import wellink.test.task.enums.ClosureType;
import wellink.test.task.models.Clothes;
import javax.persistence.Entity;

/**
 * Джинсовые штаны
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

}
