package wellink.test.task.entities.materials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wellink.test.task.models.Material;

/**
 * Материал: "шнурок"
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class Lace extends Material {

    public static Type type = Type.LACES;

}
