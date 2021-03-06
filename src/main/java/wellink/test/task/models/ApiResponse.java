package wellink.test.task.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse <T> {

    private int status;

    private String message;

    private T content;

    @Override
    public String toString() {
        return "ApiResponse:" +
                "\nstatus: " + status +
                ",\nmessage: " + message +
                ",\ncontent: " + content;
    }
}
