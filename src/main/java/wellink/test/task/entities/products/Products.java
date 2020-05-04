package wellink.test.task.entities.products;

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
public class Products {

    @Id
    private Long id;

    private Long denimCaps;
    private Long denimJackets;
    private Long denimPants;
    private Long denimSneakers;

    public Products(Long denimCaps, Long denimJackets, Long denimPants, Long denimSneakers) {
        this.denimCaps = denimCaps;
        this.denimJackets = denimJackets;
        this.denimPants = denimPants;
        this.denimSneakers = denimSneakers;
    }

    @Override
    public String toString() {
        return "denimCaps=" + denimCaps
                + ", denimJacket=" + denimJackets
                + ", denimPants=" + denimPants
                + ", denimSneakers=" + denimSneakers;
    }
}
