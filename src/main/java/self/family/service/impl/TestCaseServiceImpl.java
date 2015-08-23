package self.family.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.family.dao.TestCaseDAO;
import self.family.entry.TestCase;
import self.family.service.TestCaseService;

import java.util.List;

/**
 * Created by Administrator on 2015/8/22.
 */
@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    TestCaseDAO testCaseDAO;
    @Override
    public List<TestCase> findTestCasesByVersion(String version) {
        return testCaseDAO.findTestCasesByVersion(version);
    }

    @Override
    public TestCase findTestCaseById(int id) {
        return testCaseDAO.findTestCaseById(id);
    }

    @Override
    public boolean addTestCase(TestCase testCase) {
        return testCaseDAO.addTestCase(testCase);
    }

    @Override
    public boolean removeTestCase(int id) {
        return testCaseDAO.removeTestCase(id);
    }

    @Override
    public boolean updateTestCase(TestCase testCase) {
        return testCaseDAO.updateTestCase(testCase);
    }
}
