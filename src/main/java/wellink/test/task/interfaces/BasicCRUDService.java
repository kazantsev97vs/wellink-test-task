package wellink.test.task.interfaces;

import java.util.List;

/**
 * Базовый CRUD-сервис
 */
public interface BasicCRUDService <T> {

    T save(T entity);

    T getById(Long id);

    List<T> getAll();

    T update(T entity);

    Boolean deleteById(Long id);

    Boolean delete(T entity);
}