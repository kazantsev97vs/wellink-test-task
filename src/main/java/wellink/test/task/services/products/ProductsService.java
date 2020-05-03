package wellink.test.task.services.products;

import wellink.test.task.entities.products.Products;

/**
 * CRUD-сервис для работы с продуктами
 */
public interface ProductsService {

    Products save(Products products);

    Products getById(Long id);

    Products update(Products products);

    Boolean delete(Products products);

}
