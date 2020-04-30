package wellink.test.task.entities.materials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wellink.test.task.models.Material;

/**
 * Материал: "подошва для обуви"
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class ShoeSole extends Material {

    public static Type type = Type.SHOESOLES;

}
