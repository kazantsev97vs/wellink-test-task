package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import wellink.test.task.enums.ClosureType;
import wellink.test.task.enums.SoleThickness;
import wellink.test.task.models.Clothes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Джинсовые кроссовки
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenimSneakers extends Clothes {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private ClosureType closureType;

    private SoleThickness soleThickness;

    private Boolean isInsulated;

}
