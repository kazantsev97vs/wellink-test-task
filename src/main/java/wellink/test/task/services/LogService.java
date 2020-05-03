package wellink.test.task.services;

import wellink.test.task.entities.Log;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.LogSearchMethods;

import java.util.Date;

/**
 * CRUD-сервис для работы с логами
 */
public interface LogService extends BasicCRUDService<Log>, LogSearchMethods {

    Boolean deleteByDate(Date date);

}
