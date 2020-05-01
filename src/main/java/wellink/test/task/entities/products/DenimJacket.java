package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wellink.test.task.enums.ClosureType;
import wellink.test.task.models.Clothes;

import javax.persistence.Entity;

/**
 * Джинсовая куртка
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
