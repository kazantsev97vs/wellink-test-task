package wellink.test.task.interfaces;

import wellink.test.task.enums.Age;
import wellink.test.task.enums.Density;
import wellink.test.task.enums.Gender;
import wellink.test.task.enums.Size;
import java.util.List;

/**
 * Базовый интерфейс
 * Описывает методы репозитория сущности расширяющей класс Clothes,
 * @param <T> - тип сущности
 */
public interface BasicSearchClothesMethods<T> extends BasicSearchMaterialMethods<T> {

    List<T> findAllBySize(Size size);

    List<T> findAllByDensity(Density density);

    List<T> findAllByForWhatGender(Gender gender);

    List<T> findAllByForWhatAge(Age age);
}
