package self.family.dao;

import org.springframework.stereotype.Component;
import self.family.entry.TestVersion;

import java.util.List;

/**
 * Created by Administrator on 2015/8/24.
 */
@Component
public class TestVersionDAO extends BaseDAO {
    public List<TestVersion> findAllVersions() {
        return getSqlSession().selectList("findAllVersions");
    }

    public boolean addVersion(TestVersion testVersion) {
        return getSqlSession().insert("addVersion", testVersion) == 1 ? true : false;
    }
}
