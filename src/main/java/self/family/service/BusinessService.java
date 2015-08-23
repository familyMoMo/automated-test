package self.family.service;

import self.family.entry.ResultVO;
import self.family.entry.TestCase;
import self.family.entry.TestResult;

import java.util.List;

/**
 * Created by Administrator on 2015/8/23.
 */
public interface BusinessService {
    public List<TestResult> excute(List<TestCase> testCaseList, String tagName);
}
