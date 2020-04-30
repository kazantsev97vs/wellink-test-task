package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import wellink.test.task.enums.ClosureType;
import wellink.test.task.models.Clothes;

/**
 * Джинсовые штаны
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DenimPants that = (DenimPants) o;

        if (isSkinny != null ? !isSkinny.equals(that.isSkinny) : that.isSkinny != null) return false;
        if (isStretch != null ? !isStretch.equals(that.isStretch) : that.isStretch != null) return false;
        if (closureType != that.closureType) return false;
        return isInsulated != null ? isInsulated.equals(that.isInsulated) : that.isInsulated == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isSkinny != null ? isSkinny.hashCode() : 0);
        result = 31 * result + (isStretch != null ? isStretch.hashCode() : 0);
        result = 31 * result + (closureType != null ? closureType.hashCode() : 0);
        result = 31 * result + (isInsulated != null ? isInsulated.hashCode() : 0);
        return result;
    }
}
