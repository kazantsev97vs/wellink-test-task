package wellink.test.task.models.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wellink.test.task.Database;
import wellink.test.task.entities.materials.*;
import wellink.test.task.entities.materials.Thread;

import java.util.List;

@Component
@Data
@Scope("prototype")
public class MaterialAmountReport {

    @Autowired
    private Database database;

    // materials
    private List<Buttons> buttonsList;
    private List<Denim> denimList;
    private List<Lace> laceList;
    private List<Lock> lockList;
    private List<ShoeSole> shoeSoleList;
    private List<Thread> threadList;

    public MaterialAmountReport() {
        this.buttonsList = database.getButtonsList();
        this.denimList = database.getDenimList();
        this.laceList = database.getLaceList();
        this.lockList = database.getLockList();
        this.shoeSoleList = database.getShoeSoleList();
        this.threadList = database.getThreadList();
    }
}
