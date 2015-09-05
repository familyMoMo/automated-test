package self.family.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import self.family.entry.PageVO;
import self.family.entry.TestCase;
import self.family.entry.TestVersion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/22.
 */
@Component
public class TestCaseDAO extends BaseDAO{

    public List<TestCase> findTestCasesByVersion(String version) {
        return getSqlSession().selectList("findTestCasesByVersion", version);
    }

    public TestCase findTestCaseById(int id) {
        return getSqlSession().selectOne("findTestCaseById", id);
    }

    public boolean addTestCase(TestCase testCase) {
        return getSqlSession().insert("addTestCase", testCase) == 1 ? true : false;
    }

    public boolean batchRemove(String[] ids){
        return getSqlSession().delete("batchRemoveCase", ids) == ids.length ? true : false;
    }

    public boolean updateTestCase(TestCase testCase){
        return getSqlSession().update("updateTestCase", testCase) == 1 ? true : false;
    }

    public PageVO<TestCase> getPage(int pageNumber, int pageSize) {
        return this.getPage("getPage", null, pageNumber, pageSize);
    }

    public PageVO<TestCase> findPageCaseByVersion(String version, int pageNumber, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("version", version);
        return this.getPage("findPageCaseByVersion", map, pageNumber, pageSize);
    }
}
