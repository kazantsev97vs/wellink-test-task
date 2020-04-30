package wellink.test.task.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wellink.test.task.models.ApiResponse;
import wellink.test.task.models.reports.OrderProcessingStatisticsReport;

@RestController
public class FirmController {

    /**
     * Показать отчет статистики обработки заказов
     * @return
     */
    @GetMapping("/statistics-report")
    public ApiResponse<OrderProcessingStatisticsReport> showOrderProcessingStatisticsReport() {

        OrderProcessingStatisticsReport report = new OrderProcessingStatisticsReport();

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "All statistics",
                report
        );
    }

    /**
     * предоставить количество материала
     */
//    public ApiResponse<>


}
