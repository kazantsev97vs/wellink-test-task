package wellink.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wellink.test.task.entities.materials.Materials;
import wellink.test.task.models.ApiResponse;
import wellink.test.task.models.reports.OrderProcessingStatisticsReport;
import wellink.test.task.services.materials.MaterialsService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FirmController {

    @Autowired
    private MaterialsService materialsService;

    /**
     * Показать отчет статистики обработки заказов
     * @return
     */
    @PostMapping("/statistics-report")
    public ApiResponse<OrderProcessingStatisticsReport> showOrderProcessingStatisticsReport() {

        OrderProcessingStatisticsReport report = new OrderProcessingStatisticsReport(1, "a");

        System.out.println(report);
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "All statistics",
                report
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


}
