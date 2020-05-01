package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wellink.test.task.enums.CapType;
import wellink.test.task.models.Clothes;
import javax.persistence.Entity;

/**
 * Джинсовая кепка
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}