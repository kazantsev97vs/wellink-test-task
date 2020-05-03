package wellink.test.task.entities.materials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Материалы
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materials {

    @Id
    private Long id;

    private Long buttons;
    private Long denims;
    private Long laces;
    private Long locks;
    private Long shoeSoles;
    private Long threadRolls;

    public Materials(Long buttons, Long denims, Long laces, Long locks, Long shoeSoles, Long threadRolls) {
        this.buttons = buttons;
        this.denims = denims;
        this.laces = laces;
        this.locks = locks;
        this.shoeSoles = shoeSoles;
        this.threadRolls = threadRolls;
    }

    @Override
    public String toString() {
        return "buttons=" + buttons
                + ", denims=" + denims
                + ", laces=" + laces
                + ", locks=" + locks
                + ", shoeSoles=" + shoeSoles
                + ", threadRolls=" + threadRolls + "\n";
    }
}
