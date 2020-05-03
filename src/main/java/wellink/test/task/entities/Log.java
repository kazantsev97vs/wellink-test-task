package wellink.test.task.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date date;

    @NotNull
    private Status status;

    @NotNull
    private String message;

    private String type;

    private Action action;

    public Log(@NotNull Date date, @NotNull Status status, @NotNull String message, String type, Action action) {
        this.date = date;
        this.status = status;
        this.message = message;
        this.type = type;
        this.action = action;
    }

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