package wellink.test.task.services;

import wellink.test.task.entities.Log;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.interfaces.LogSearchMethods;

/**
 * CRUD-сервис для работы с логами
 */
public interface LogService extends BasicCRUDService<Log>, LogSearchMethods {

    Log info(String message, String type, Log.Action action);

    Log info(String message, Object object, Log.Action action);

    Log info(Object object, Log.Action action);

    Log error(String message, String type, Log.Action action);

}
