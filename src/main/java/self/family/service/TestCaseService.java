package self.family.service;

import self.family.entry.PageVO;
import self.family.entry.TestCase;

import java.util.List;

/**
 * Created by Administrator on 2015/8/22.
 */
public interface TestCaseService {
    public List<TestCase> findTestCasesByVersion(String version);

    public TestCase findTestCaseById(int id);

    public boolean addTestCase(TestCase testCase);

    public boolean removeTestCase(int id);

    public boolean updateTestCase(TestCase testCase);

    PageVO<TestCase> findPageCaseByVersion(String version, int pageNumber, int pageSize);
}
