package wellink.test.task.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wellink.test.task.enums.CapType;
import wellink.test.task.models.Clothes;

/**
 * Джинсовая кепка
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
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
    private Boolean isThereCapSizeAdjustment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DenimCap denimCap = (DenimCap) o;

        if (visorLength != null ? !visorLength.equals(denimCap.visorLength) : denimCap.visorLength != null)
            return false;
        if (capType != denimCap.capType) return false;
        return isThereCapSizeAdjustment != null ? isThereCapSizeAdjustment.equals(denimCap.isThereCapSizeAdjustment) : denimCap.isThereCapSizeAdjustment == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (visorLength != null ? visorLength.hashCode() : 0);
        result = 31 * result + (capType != null ? capType.hashCode() : 0);
        result = 31 * result + (isThereCapSizeAdjustment != null ? isThereCapSizeAdjustment.hashCode() : 0);
        return result;
    }
}