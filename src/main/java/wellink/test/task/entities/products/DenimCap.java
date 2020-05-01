package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wellink.test.task.enums.CapType;
import wellink.test.task.models.Clothes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Джинсовая кепка
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenimCap extends Clothes {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

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
    private Boolean isThereCapSizeAdjustment;

}