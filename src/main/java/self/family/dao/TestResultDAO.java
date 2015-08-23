package self.family.dao;

import org.springframework.stereotype.Component;
import self.family.entry.TestResult;

import java.util.List;

/**
 * Created by Administrator on 2015/8/22.
 */
@Component
public class TestResultDAO extends BaseDAO{
    public List<TestResult> findTestResultsByTag(int tag) {
        return getSqlSession().selectList("findTestResultsByTag", tag);
    }

    public boolean removeTestResultsByTag(int tag) {
        return getSqlSession().delete("removeTestResultsByTag", tag) > 0 ? true : false;
    }

    public int findMaxTag() {
        Object tag = getSqlSession().selectOne("findMaxTag");
        return tag == null ? 0 : (Integer)tag;
    }

    public boolean addTestResult(TestResult testResult) {
        return getSqlSession().insert("addTestResult", testResult) == 1 ? true : false;
    }

    public boolean batchAdd(List<TestResult> testResults) {
        return getSqlSession().insert("batchAdd", testResults) == testResults.size() ? true : false;
    }
}
