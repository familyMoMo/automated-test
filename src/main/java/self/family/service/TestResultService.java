package self.family.service;

import org.junit.Test;
import self.family.entry.PageVO;
import self.family.entry.TestResult;

import java.util.List;

/**
 * Created by Administrator on 2015/8/22.
 */
public interface TestResultService {
    public List<TestResult> findTestResultsByTag(int tag);

    public List<String> findAllTagNames();

    public boolean removeTestResultsByTagName(String tagName);

    public int findMaxTag();

    public boolean addTestResult(TestResult testResult);

    public boolean batchAdd(List<TestResult> testResults);

    public PageVO<TestResult> findPageResultByTagName(String tagName, int pageNumber, int pageSize);

    public boolean batchRemove(String[] ids);
}
