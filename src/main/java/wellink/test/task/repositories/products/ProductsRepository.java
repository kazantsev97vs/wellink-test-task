package wellink.test.task.repositories.products;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.products.Products;

import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long> {

    List<Products> getBy(Pageable pageable);

}
