package wellink.test.task.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wellink.test.task.entities.Log;
import wellink.test.task.entities.materials.Button;
import wellink.test.task.entities.materials.Materials;
import wellink.test.task.entities.products.Products;
import wellink.test.task.models.ApiResponse;
import wellink.test.task.services.FirmService;
import wellink.test.task.services.LogService;
import wellink.test.task.services.materials.*;
import wellink.test.task.services.products.ProductsService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FirmController {

    @Autowired
    private LogService logService;

    @Autowired
    private MaterialsService materialsService;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private FirmService firmService;

    // MATERIALS
    @Autowired
    private ButtonService buttonService;
    @Autowired
    private DenimService denimService;
    @Autowired
    private LaceService laceService;
    @Autowired
    private LockService lockService;
    @Autowired
    private ShoeSoleService shoeSoleService;
    @Autowired
    private ThreadRollService threadRollService;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Report {
        private Materials materials;
        private Products products;
        private List<Log> logList;
    }

    /**
     * Показать отчет статистики обработки заказов
     *
     * @return
     */
    @PostMapping("/statistics-report")
    public ApiResponse<Report> showOrderProcessingStatisticsReport() {

        Materials materials = materialsService.get();
        Products products = productsService.get();
        List<Log> logList = logService.getAll();

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Order Processing Statistics Report",
                new Report(materials, products, logList)
        );
    }

    /**
     * предоставить количество материала
     */
    @PostMapping("/amount-material")
    public ApiResponse<Materials> provideAmountMaterial() {
        Materials materials = materialsService.get();

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Amount of material",
                materials
        );
    }


    @PostMapping("/take-buttons")
    public ApiResponse<Double> takeDeliveryOfButtons (@RequestBody List<Button> buttonList) {

        List<Button> savedButtonList = buttonService.saveAll(buttonList);

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Payment for " + buttonList.size() + " buttons:\n" + savedButtonList,
                firmService.countTotalPrice(buttonList)
        );
    }
}
