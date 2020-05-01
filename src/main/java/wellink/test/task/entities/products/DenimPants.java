package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import wellink.test.task.enums.ClosureType;
import wellink.test.task.models.Clothes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Джинсовые штаны
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DenimPants extends Clothes {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

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
