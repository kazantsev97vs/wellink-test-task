package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wellink.test.task.enums.ClosureType;
import wellink.test.task.enums.SoleThickness;
import wellink.test.task.models.Clothes;
import javax.persistence.Entity;

/**
 * Джинсовые кроссовки
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenimSneakers extends Clothes {

    private ClosureType closureType;

    private SoleThickness soleThickness;

    private Boolean isInsulated;

}
