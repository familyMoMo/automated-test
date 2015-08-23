package self.family.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.family.dao.TestResultDAO;
import self.family.entry.TestResult;
import self.family.service.TestResultService;

import java.util.List;

/**
 * Created by Administrator on 2015/8/22.
 */
@Service
public class TestResultServiceImpl implements TestResultService {
    @Autowired
    TestResultDAO testResultDAO;
    @Override
    public List<TestResult> findTestResultsByTag(int tag) {
        return testResultDAO.findTestResultsByTag(tag);
    }

    @Override
    public boolean removeTestResultsByTag(int tag) {
        return testResultDAO.removeTestResultsByTag(tag);
    }

    @Override
    public int findMaxTag() {
        return testResultDAO.findMaxTag();
    }

    @Override
    public boolean addTestResult(TestResult testResult) {
        return testResultDAO.addTestResult(testResult);
    }

    @Override
    public boolean batchAdd(List<TestResult> testResults) {
        return testResultDAO.batchAdd(testResults);
    }


}
