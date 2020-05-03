package wellink.test.task.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {

    @Id
    @NotNull
    private Date date;

    @NotNull
    private Status status;

    @NotNull
    private String message;

    private String type;

    private Action action;

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

    public enum Action {
        SAVE,
        GET,
        UPDATE,
        DELETE
    }

    @Override
    public String toString() {
        return "date=" + date
                + ",\n status=" + status
                + ",\n message='" + message + '\''
                + ",\n type='" + type + '\''
                + ",\n action=" + action + '\n';
    }
}