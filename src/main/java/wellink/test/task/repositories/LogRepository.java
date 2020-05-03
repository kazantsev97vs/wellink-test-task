package wellink.test.task.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellink.test.task.entities.Log;
import wellink.test.task.interfaces.LogSearchMethods;

import java.util.Date;

@Repository
public interface LogRepository extends
        CrudRepository <Log, Date>, LogSearchMethods {
}
