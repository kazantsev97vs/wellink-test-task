package wellink.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wellink.test.task.entities.materials.*;
import wellink.test.task.models.ApiResponse;
import wellink.test.task.services.FirmService;
import wellink.test.task.services.materials.*;

import java.util.List;

/**
 * Управление поставками
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController("/supply-management")
public class SupplyManagementController {

    @Autowired
    private FirmService firmService;

    // MATERIALS -------------------------------
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


    @PostMapping("/buy-buttons")
    public ApiResponse<Double> buyButtons(List<Button> buttonList) {
        List<Button> savedButtonList = buttonService.saveAll(buttonList);

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Payment for " + buttonList.size() + " buttons:\n" + savedButtonList,
                firmService.countTotalPrice(buttonList)
        );
    }

    @PostMapping("/buy-denims")
    public ApiResponse<Double> buyDenims(List<Denim> denimList) {
        List<Denim> savedDenimList = denimService.saveAll(denimList);

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Payment for " + denimList.size() + " denims:\n" + savedDenimList,
                firmService.countTotalPrice(denimList)
        );
    }

    @PostMapping("/buy-laces")
    public ApiResponse<Double> buyLaces(List<Lace> laceList) {
        List<Lace> savedLaceList = laceService.saveAll(laceList);

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Payment for " + laceList.size() + " laces:\n" + savedLaceList,
                firmService.countTotalPrice(laceList)
        );
    }

    @PostMapping("/buy-locks")
    public ApiResponse<Double> buyLocks(List<Lock> lockList) {
        List<Lock> savedLockList = lockService.saveAll(lockList);

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Payment for " + lockList.size() + " locks:\n" + savedLockList,
                firmService.countTotalPrice(lockList)
        );
    }

    @PostMapping("/buy-shoe-soles")
    public ApiResponse<Double> buyShoeSoles(List<ShoeSole> shoeSoleList) {
        List<ShoeSole> savedShoeSoleList = shoeSoleService.saveAll(shoeSoleList);

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Payment for " + shoeSoleList.size() + " shoeSoles:\n" + savedShoeSoleList,
                firmService.countTotalPrice(shoeSoleList)
        );
    }

    @PostMapping("/buy-thread-rolls")
    public ApiResponse<Double> buyThreadRolls(List<ThreadRoll> threadRollList) {
        List<ThreadRoll> ThreadRollList = threadRollService.saveAll(threadRollList);

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Payment for " + threadRollList.size() + " threadRolls:\n" + ThreadRollList,
                firmService.countTotalPrice(threadRollList)
        );
    }
}
