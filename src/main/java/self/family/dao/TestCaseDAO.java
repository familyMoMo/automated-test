package self.family.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import self.family.entry.TestCase;

import java.util.List;

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

    public boolean removeTestCase(int id){
        return getSqlSession().delete("removeTestCase", id) == 1 ? true : false;
    }

    public boolean updateTestCase(TestCase testCase){
        return getSqlSession().update("updateTestCase", testCase) == 1 ? true : false;
    }
}
