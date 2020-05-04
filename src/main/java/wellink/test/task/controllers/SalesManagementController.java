package wellink.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wellink.test.task.entities.products.DenimCap;
import wellink.test.task.entities.products.DenimJacket;
import wellink.test.task.entities.products.DenimPants;
import wellink.test.task.entities.products.DenimSneakers;
import wellink.test.task.models.ApiResponse;
import wellink.test.task.models.SoldGoods;
import wellink.test.task.services.FirmService;
import wellink.test.task.services.products.DenimCapService;
import wellink.test.task.services.products.DenimJacketService;
import wellink.test.task.services.products.DenimPantsService;
import wellink.test.task.services.products.DenimSneakersService;

import java.util.List;

/**
 * Управление продажами
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController("/sales-management")
public class SalesManagementController {

    @Autowired
    private FirmService firmService;

    // PRODUCTS --------------------------------------
    @Autowired
    private DenimCapService denimCapService;

    @Autowired
    private DenimJacketService denimJacketService;

    @Autowired
    private DenimPantsService denimPantsService;

    @Autowired
    private DenimSneakersService denimSneakersService;

    @PostMapping("/sell-denim-caps")
    public ApiResponse<SoldGoods<DenimCap>> sellDenimCaps(List<DenimCap> denimCaps, Double payment) {

        SoldGoods<DenimCap> denimCapSoldGoods = firmService.sellProducts(denimCaps, denimCapService);

        if (denimCapSoldGoods == null) {
            return new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "Couldn't find all products\n" + denimCaps,
                    null
            );
        }

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "For " + payment + "$ selling " + denimCaps.size() + " denimCaps",
                denimCapSoldGoods
        );
    }



    @PostMapping("/sell-denim-jackets")
    public ApiResponse<Double> sellDenimJackets(List<DenimJacket> denimJackets) {
        List<DenimJacket> savedDenimJacketList = denimJacketService.saveAll(denimJackets);

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Payment for " + denimJackets.size() + " denimJackets:\n" + savedDenimJacketList,
                firmService.countTotalPrice(denimJackets)
        );
    }

    @PostMapping("/sell-denim-pants")
    public ApiResponse<Double> sellDenimPants(List<DenimPants> denimPants) {
        List<DenimPants> savedDenimPantsList = denimPantsService.saveAll(denimPants);

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Payment for " + denimPants.size() + " denimPants:\n" + savedDenimPantsList,
                firmService.countTotalPrice(denimPants)
        );
    }

    @PostMapping("/sell-denim-sneakers")
    public ApiResponse<Double> sellDenimSneakers(List<DenimSneakers> denimSneakers) {
        List<DenimSneakers> savedDenimSneakersList = denimSneakersService.saveAll(denimSneakers);

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Payment for " + denimSneakers.size() + " denimSneakers:\n" + savedDenimSneakersList,
                firmService.countTotalPrice(denimSneakers)
        );
    }
}
