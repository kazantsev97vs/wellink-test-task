package wellink.test.task;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wellink.test.task.controllers.FirmController;
import wellink.test.task.entities.materials.Button;
import wellink.test.task.enums.Color;
import wellink.test.task.models.ApiResponse;
import wellink.test.task.services.FirmService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FirmControllerTest {

    @Autowired
    private FirmController firmController;

    @Autowired
    private FirmService firmService;


    @Test
    public void contextLoads() throws Exception {

        assertThat(firmController).isNotNull();

    }

    @Test
    public void shouldMethodTakeDeliveryOfButtonsReturnTotalPriceInResponse() {
        List<Button> buttonList = new ArrayList<>();
        buttonList.add(new Button( "Квадратный блеск", 20.0, Color.AQUA));
        buttonList.add(new Button( "Круглый блеск", 25.0, Color.AQUA));

        double price = 0;
        for (Button b : buttonList) price += b.getPrice();

        ApiResponse<Double> apiResponse = firmController.takeDeliveryOfButtons(buttonList);

        Assert.assertNotNull("apiResponse is null", apiResponse);
        Assert.assertEquals(200, apiResponse.getStatus());
        Assert.assertEquals(price, apiResponse.getContent(), 1e-9);

        System.out.println(apiResponse);
    }
}
