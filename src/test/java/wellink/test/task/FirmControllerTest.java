package wellink.test.task;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wellink.test.task.controllers.FirmController;
import wellink.test.task.entities.materials.Button;
import wellink.test.task.enums.Color;
import wellink.test.task.models.ApiResponse;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FirmControllerTest {

    @Autowired
    private FirmController firmController;

    @Test
    public void contextLoads() throws Exception {

        assertThat(firmController).isNotNull();

        List<Button> buttonList = new ArrayList<>();
        buttonList.add(new Button(1L, "Квадратный блеск", 20.0, Color.AQUA));
        Double price = buttonList.get(0).getPrice();

        ApiResponse<Double> apiResponse = firmController.takeDeliveryOfButtons(buttonList);


        Assert.assertNotNull("apiResponse is null", apiResponse);

        Assert.assertEquals(price, apiResponse.getContent(), 1e-9);

    }
}
