package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wellink.test.task.enums.ClosureType;
import wellink.test.task.models.Clothes;

/**
 * Джинсовая куртка
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class DenimJacket extends Clothes {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DenimJacket that = (DenimJacket) o;

        if (isThereHood != null ? !isThereHood.equals(that.isThereHood) : that.isThereHood != null) return false;
        if (pocketsNumber != null ? !pocketsNumber.equals(that.pocketsNumber) : that.pocketsNumber != null)
            return false;
        if (sleeveLength != null ? !sleeveLength.equals(that.sleeveLength) : that.sleeveLength != null) return false;
        if (isInsulated != null ? !isInsulated.equals(that.isInsulated) : that.isInsulated != null) return false;
        return closureType == that.closureType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isThereHood != null ? isThereHood.hashCode() : 0);
        result = 31 * result + (pocketsNumber != null ? pocketsNumber.hashCode() : 0);
        result = 31 * result + (sleeveLength != null ? sleeveLength.hashCode() : 0);
        result = 31 * result + (isInsulated != null ? isInsulated.hashCode() : 0);
        result = 31 * result + (closureType != null ? closureType.hashCode() : 0);
        return result;
    }
}
