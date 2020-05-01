package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wellink.test.task.enums.ClosureType;
import wellink.test.task.models.Clothes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Джинсовая куртка
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenimJacket extends Clothes {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    /**
     * С капюшоном куртка или нет
     */
    private Boolean isThereHood;

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
