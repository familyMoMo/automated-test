package self.family.dao;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import self.family.entry.TestResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestResultDAOTest extends BaseTest {

    @Autowired
    TestResultDAO testResultDAO;

    @Test
    public void testFindTestResultsByTag() throws Exception {
        List<TestResult> testResults = testResultDAO.findTestResultsByTag(0);
        System.out.println(testResults == null ? "null" : testResults.get(0).getCaseName());
    }

    @Test
    public void testFindMaxTag() throws Exception {
        System.out.println(testResultDAO.findMaxTag());
    }

    @Test
    public void testBatchAdd() throws Exception {
        List<TestResult> testResults = new ArrayList<TestResult>();
//        int caseId, String caseName, String expectResponse, String actualResponse, String result, int tag, String tagName, Date
//        createTime
        testResults.add(new TestResult(1, "lala", "123", "123", "PASSED", 1, "o", new Date()));
        testResults.add(new TestResult(2, "lala", "123", "1234", "FAILED", 1, "oy", new Date()));
        System.out.println(testResultDAO.batchAdd(testResults));
    }

    @Test
    public void testBatchRemove() throws Exception {
        System.out.println(testResultDAO.batchRemove(new String[]{"7"}));
    }
}