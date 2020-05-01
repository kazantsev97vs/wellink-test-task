package wellink.test.task.entities.materials;

import wellink.test.task.models.Material;
import javax.persistence.Entity;


/**
 * Материал: "рулон ниток"
 */
@Entity
public class ThreadRoll extends Material {

    public static Type type = Type.THREADS;
}
