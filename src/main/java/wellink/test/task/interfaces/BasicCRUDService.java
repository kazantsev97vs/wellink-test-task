package wellink.test.task.interfaces;

import java.util.List;

/**
 * Базовый CRUD-сервис
 */
public interface BasicCRUDService <T> {

    T save(T entity);

    List<T> saveAll(List<T> entities);

    T getById(Long id);

    List<T> getAll();

//    List<T> getAll(Pageable page);

    T update(T entity);

    Boolean deleteById(Long id);

    Boolean delete(T entity);

    Boolean deleteAll(List<T> entities);
}