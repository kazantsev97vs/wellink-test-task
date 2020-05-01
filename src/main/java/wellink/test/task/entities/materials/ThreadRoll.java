package wellink.test.task.entities.materials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wellink.test.task.models.Material;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Материал: "рулон ниток"
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadRoll extends Material {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    public static Type type = Type.THREADS;

}
