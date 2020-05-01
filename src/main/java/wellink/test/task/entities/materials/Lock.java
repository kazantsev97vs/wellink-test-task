package wellink.test.task.entities.materials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wellink.test.task.models.Material;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Материал: "замок"
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lock extends Material {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    public static Type type = Type.LOCKS;

}
