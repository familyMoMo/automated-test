package self.family.dao;

import org.springframework.stereotype.Component;
import self.family.entry.PageVO;
import self.family.entry.TestResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/22.
 */
@Component
public class TestResultDAO extends BaseDAO{
    public List<TestResult> findTestResultsByTag(int tag) {
        return getSqlSession().selectList("findTestResultsByTag", tag);
    }

    public List<String> findAllTagNames() {
        return getSqlSession().selectList("getAllTagNames");
    }

    public boolean removeTestResultsByTagName(String tagName) {
        return getSqlSession().delete("removeTestResultsByTagName", tagName) > 0 ? true : false;
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

    public PageVO<TestResult> getPage(int pageNumber, int pageSize) {
        return this.getPage("getPage", null, pageNumber, pageSize);
    }

    public PageVO<TestResult> findPageResultByTagName(String tagName, int pageNumber, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tagName", tagName);
        return this.getPage("findPageResultByTagName", map, pageNumber, pageSize);
    }

    public boolean batchRemove(String[] ids){
        return getSqlSession().delete("batchRemoveResult", ids) == ids.length ? true : false;
    }
}
