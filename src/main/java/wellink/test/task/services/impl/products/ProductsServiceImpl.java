package wellink.test.task.services.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.products.Products;
import wellink.test.task.repositories.products.ProductsRepository;
import wellink.test.task.services.products.ProductsService;

/**
 * Реализация CRUD-сервиса для работы с продуктами
 */
@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Products save(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public Products getById(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    @Override
    public Products update(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public Boolean delete(Products products) {
        productsRepository.delete(products);
        return !productsRepository.findById(products.getId()).isPresent();
    }
}
