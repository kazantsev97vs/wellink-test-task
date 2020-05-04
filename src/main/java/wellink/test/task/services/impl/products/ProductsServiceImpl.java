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

    private final Long ID = 1L;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Products save(Products products) {
        products.setId(ID);
        Products savedProducts = get();

        if (savedProducts != null) {
            products.setDenimCaps(products.getDenimCaps() + savedProducts.getDenimCaps());
            products.setDenimJackets(products.getDenimJackets() + savedProducts.getDenimJackets());
            products.setDenimPants(products.getDenimPants() + savedProducts.getDenimPants());
            products.setDenimSneakers(products.getDenimSneakers() + savedProducts.getDenimSneakers());
        }

        return productsRepository.save(products);
    }

    @Override
    public Products get() {
        return productsRepository.findById(ID).orElse(null);
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
