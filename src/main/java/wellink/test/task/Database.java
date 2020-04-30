package wellink.test.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import wellink.test.task.entities.materials.*;
import wellink.test.task.entities.materials.Thread;
import wellink.test.task.entities.products.DenimCap;
import wellink.test.task.entities.products.DenimJacket;
import wellink.test.task.entities.products.DenimPants;
import wellink.test.task.entities.products.DenimSneakers;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Database {

    // materials
    private List<Buttons> buttonsList = new ArrayList<>();
    private List<Denim> denimList = new ArrayList<>();
    private List<Lace> laceList = new ArrayList<>();
    private List<Lock> lockList = new ArrayList<>();
    private List<ShoeSole> shoeSoleList = new ArrayList<>();
    private List<Thread> threadList = new ArrayList<>();

    // products
    private List<DenimCap> denimCapList = new ArrayList<>();
    private List<DenimJacket> denimJacketList = new ArrayList<>();
    private List<DenimPants> denimPantsList = new ArrayList<>();
    private List<DenimSneakers> denimSneakersList = new ArrayList<>();

}
