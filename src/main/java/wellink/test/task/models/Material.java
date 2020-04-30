package wellink.test.task.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wellink.test.task.enums.Color;

/**
 * Единица товара
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Material {

    private Integer id;

    private Double price;

    private Color color;

    public static enum Type {
        BUTTONS,    // "пуговицы"
        DENIM,      // "джинсовая ткань"
        LACES,      // "шнукри"
        LOCKS,      // "замки"
        SHOESOLES,  // "подошва для обуви"
        THREADS,    // "нитки"
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Material material = (Material) o;

        if (id != null ? !id.equals(material.id) : material.id != null) return false;
        if (price != null ? !price.equals(material.price) : material.price != null) return false;
        return color == material.color;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
