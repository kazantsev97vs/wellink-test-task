package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import wellink.test.task.enums.ClosureType;
import wellink.test.task.enums.SoleThickness;
import wellink.test.task.models.Clothes;

/**
 * Джинсовые кроссовки
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class DenimSneakers extends Clothes {

    private ClosureType closureType;

    private SoleThickness soleThickness;

    private Boolean isInsulated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DenimSneakers that = (DenimSneakers) o;

        if (closureType != that.closureType) return false;
        if (soleThickness != that.soleThickness) return false;
        return isInsulated != null ? isInsulated.equals(that.isInsulated) : that.isInsulated == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (closureType != null ? closureType.hashCode() : 0);
        result = 31 * result + (soleThickness != null ? soleThickness.hashCode() : 0);
        result = 31 * result + (isInsulated != null ? isInsulated.hashCode() : 0);
        return result;
    }
}
