package self.family.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import self.family.entry.TestCase;
import self.family.util.JsonUtil;

import java.io.IOException;
import java.util.List;


public class TestCaseDAOTest extends BaseTest {

    @Autowired
    TestCaseDAO testCaseDAO;
    @Test
    public void testFindTestCaseByVersion() throws Exception {
        List<TestCase> testCases = testCaseDAO.findTestCasesByVersion("1.0.0");
        System.out.println(testCases == null ? "null" : testCases.get(0).getVersion());
    }

    @Test
    public void testFindTestCaseById() throws Exception {
        TestCase testCase = testCaseDAO.findTestCaseById(1);
        System.out.println(testCase == null ? "null" : testCase.getVersion());
    }

    @Test
    public void testAddTestCase() throws Exception {
        for (int i = 0; i < 50; i++) {
            TestCase testCase = new TestCase();
            testCase.setUrl("http://www.baidu.com");
            testCase.setCaseName("lalala");
            testCase.setVersion("1.0.2");
            testCase.setRequestMethod("get");
            testCase.setResponseResolver("http-code");
            testCase.setExpectResponse("200");
            System.out.println(testCaseDAO.addTestCase(testCase));
        }

    }

    @Test
    public void testRemoveTestCase() throws Exception {
        System.out.println(testCaseDAO.removeTestCase(1));
    }

    @Test
    public void testUpdateTestCase() throws Exception {
        TestCase testCase = new TestCase();
        testCase.setId(2);
        testCase.setUrl("http://www.baidu.com");
        testCase.setCaseName("dadada");
        testCase.setVersion("1.0.2");
        testCase.setRequestMethod("get");
        testCase.setResponseResolver("http-code");
        testCase.setExpectResponse("200");
        System.out.println(testCaseDAO.updateTestCase(testCase));
    }

    @Test
    public void testPage() {
        try {
            System.out.println(JsonUtil.toJson(testCaseDAO.getPage(1, 10)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findPageCaseByVersion() {
        try {
            System.out.println(JsonUtil.toJson(testCaseDAO.findPageCaseByVersion("1.0.1", 1, 10)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}