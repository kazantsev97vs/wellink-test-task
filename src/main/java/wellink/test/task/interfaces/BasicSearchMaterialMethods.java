package wellink.test.task.interfaces;

import org.springframework.data.domain.Pageable;
import wellink.test.task.enums.Color;

import java.util.List;

/**
 * Базовый интерфейс
 * Описывает методы репозитория сущности расширяющей класс Material
 * @param <T> - тип сущности
 */
public interface BasicSearchMaterialMethods<T> {

    List<T> getAllByName(String name);

    List<T> getAllByPrice(Double price);

    List<T> getAllByColor(Color color);

    List<T> getAllByColor(Color color, Pageable page);

}
