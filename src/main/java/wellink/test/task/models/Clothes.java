package wellink.test.task.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wellink.test.task.enums.*;

/**
 * Одежда
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Clothes {

    private Size size;

    private Color color;

    private FabricDensity fabricDensity;

    private Gender gender;

    private Age forWhatAge;

}
