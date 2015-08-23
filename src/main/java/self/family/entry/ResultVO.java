package self.family.entry;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/8/23.
 */
public class ResultVO implements Serializable {
    private static final long serialVersionUID = -555879629679595233L;
    private String status;
    private String message;

    public ResultVO() {

    }

    public ResultVO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
