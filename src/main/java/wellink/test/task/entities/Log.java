package wellink.test.task.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {

    @Id
    private Date date;

    private Status status;

    private String message;

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public void setType(Object object) {
        if (object != null) {
            this.type = object.getClass().getSimpleName();
        }
    }

    public enum Status {
        INFO,
        ERROR
    }
}