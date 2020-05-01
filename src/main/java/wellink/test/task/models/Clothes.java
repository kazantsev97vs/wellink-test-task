package wellink.test.task.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wellink.test.task.enums.*;
import javax.persistence.MappedSuperclass;

/**
 * Одежда
 */
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Clothes extends Material {

    private Size size;

    private FabricDensity fabricDensity;

    private Gender gender;

    private Age forWhatAge;

}
