package self.family.entry;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/8/24.
 */
public class TestVersion implements Serializable {

    private static final long serialVersionUID = 3420185249846188081L;

    private int id;
    private String version;

    public TestVersion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
