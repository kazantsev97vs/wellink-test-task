package wellink.test.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import wellink.test.task.entities.materials.Materials;
import wellink.test.task.entities.products.Products;
import wellink.test.task.repositories.materials.MaterialsRepository;
import wellink.test.task.repositories.products.ProductsRepository;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner init(MaterialsRepository materialsRepository, ProductsRepository productsRepository){
        return args -> {
            if (materialsRepository.findById(1L).orElse(null) == null) {
                materialsRepository.save(new Materials(1L, 0L, 0L, 0L, 0L, 0L, 0L));
            }

            if (productsRepository.findById(1L).orElse(null) == null) {
                productsRepository.save(new Products(1L, 0L, 0L, 0L, 0L));
            }
        };
    }

}

