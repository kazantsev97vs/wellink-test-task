package wellink.test.task.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * проданный товар
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoldGoods <T extends Clothes> {

    private Double goodsPrice;

    private List<T> goods;
}
