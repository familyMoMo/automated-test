package self.family.service;

import self.family.entry.TestResult;

import java.util.List;

/**
 * Created by Administrator on 2015/8/22.
 */
public interface TestResultService {
    public List<TestResult> findTestResultsByTag(int tag);

    public boolean removeTestResultsByTag(int tag);

    public int findMaxTag();

    public boolean addTestResult(TestResult testResult);

    public boolean batchAdd(List<TestResult> testResults);
}
