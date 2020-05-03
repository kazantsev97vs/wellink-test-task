package wellink.test.task.repositories.materials;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.materials.Materials;

import java.util.List;

@Repository
public interface MaterialsRepository extends CrudRepository <Materials, Long> {

    List<Materials> getBy(Pageable pageable);
}
