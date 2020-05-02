package wellink.test.task.services;

import wellink.test.task.entities.Log;
import java.util.Date;
import java.util.List;

/**
 * CRUD-сервис для работы с логами
 */
public interface LogService {

    Log save(Log log);

    Log getByDate(Date date);

    Log getFirstByDateAfter(Date date);

    Log getFirstByDateBefore(Date date);

    List<Log> getAllByDateAfter(Date date);

    List<Log> getAllByDateBefore(Date date);

    List<Log> getAllByDateBetween(Date dateAfter, Date dateBefore);

    List<Log> getAllByMessage(String message);

    List<Log> getAllByMessageLike(String message);

    List<Log> getAllByType(String type);

    List<Log> getAllByTypeLike(String type);

    List<Log> getAllByStatus(Log.Status status);

    Log update(Log log);

    Boolean deleteByDate(Date date);

    Boolean delete(Log log);
}
