package wellink.test.task.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.Log;
import wellink.test.task.repositories.LogRepository;
import wellink.test.task.services.LogService;
import java.util.Date;
import java.util.List;

/**
 * Реализация CRUD-сервиса для работы с логами
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public Log save(Log log) {
        return logRepository.save(log);
    }

    @Override
    public Log getByDate(Date date) {
        return logRepository.getByDate(date);
    }

    @Override
    public Log getFirstByDateAfter(Date date) {
        return logRepository.getFirstByDateAfter(date);
    }

    @Override
    public Log getFirstByDateBefore(Date date) {
        return logRepository.getFirstByDateBefore(date);
    }

    @Override
    public List<Log> getAllByDateAfter(Date date) {
        return logRepository.getAllByDateAfter(date);
    }

    @Override
    public List<Log> getAllByDateBefore(Date date) {
        return logRepository.getAllByDateBefore(date);
    }

    @Override
    public List<Log> getAllByDateBetween(Date dateAfter, Date dateBefore) {
        return logRepository.getAllByDateBetween(dateAfter, dateBefore);
    }

    @Override
    public List<Log> getAllByMessage(String message) {
        return logRepository.getAllByMessage(message);
    }

    @Override
    public List<Log> getAllByMessageLike(String message) {
        return logRepository.getAllByMessageLike(message);
    }

    @Override
    public List<Log> getAllByType(String type) {
        return logRepository.getAllByType(type);
    }

    @Override
    public List<Log> getAllByTypeLike(String type) {
        return logRepository.getAllByTypeLike(type);
    }

    @Override
    public List<Log> getAllByStatus(Log.Status status) {
        return logRepository.getAllByStatus(status);
    }

    @Override
    public Log update(Log log) {

        if (getByDate(log.getDate()) == null) return null;

        return logRepository.save(log);
    }

    @Override
    public Boolean deleteByDate(Date date) {
        logRepository.deleteById(date);
        return logRepository.getByDate(date) == null;
    }

    @Override
    public Boolean delete(Log log) {
        logRepository.delete(log);
        return logRepository.getByDate(log.getDate()) == null;
    }
}