package self.family.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import self.family.dao.BaseTest;
import self.family.entry.PageVO;
import self.family.entry.TestResult;
import self.family.service.TestResultService;

/**
 * Created by fanmingli on 2015/9/2.
 */
public class TestResultServiceImplTest extends BaseTest {
    @Autowired
    private TestResultService testResultService;
    @Test
    public void findPageResultByTag() {
        PageVO<TestResult> resultVO = testResultService.findPageResultByTagName("1", 1, 2);
        System.out.println(resultVO.getRows().get(0).getCaseName());
    }
}
