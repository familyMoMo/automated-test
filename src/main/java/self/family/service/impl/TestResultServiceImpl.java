package self.family.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.family.dao.TestResultDAO;
import self.family.entry.PageVO;
import self.family.entry.TestResult;
import self.family.service.TestResultService;

import java.util.List;

/**
 * Created by Administrator on 2015/8/22.
 */
@Service
public class TestResultServiceImpl implements TestResultService {
    @Autowired
    private TestResultDAO testResultDAO;
    @Override
    public List<TestResult> findTestResultsByTag(int tag) {
        return testResultDAO.findTestResultsByTag(tag);
    }

    @Override
    public List<String> findAllTagNames() {
        return testResultDAO.findAllTagNames();
    }

    @Override
    public boolean removeTestResultsByTagName(String tagName) {
        return testResultDAO.removeTestResultsByTagName(tagName);
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

    @Override
    public PageVO<TestResult> findPageResultByTagName(String tagName, int pageNumber, int pageSize) {
        return testResultDAO.findPageResultByTagName(tagName, pageNumber, pageSize);
    }

    @Override
    public boolean batchRemove(String[] ids) {
        return testResultDAO.batchRemove(ids);
    }

}
