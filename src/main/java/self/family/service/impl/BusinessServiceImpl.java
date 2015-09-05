package self.family.service.impl;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import self.family.constant.TestResultConstant;
import self.family.entry.ResultVO;
import self.family.entry.TestCase;
import self.family.entry.TestResult;
import self.family.enumeration.HandlerEnum;
import self.family.resolver.BaseResolver;
import self.family.service.BusinessService;
import self.family.service.TestResultService;
import self.family.util.SpringContextUtil;
import self.family.util.TestCaseHttpUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/8/23.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private TestResultService testResultService;
    private TestResult excute(TestCase testCase, String tagName) {
        try {
            HttpResponse httpResponse = TestCaseHttpUtil.execute(testCase);
            String resolverName = HandlerEnum.getEnum(testCase.getResponseResolver()).getBeanName();
            BaseResolver resolver = (BaseResolver) SpringContextUtil.getBean(resolverName);
            String actualResponse = resolver.handle(httpResponse);
            return new TestResult(testCase.getId(), testCase.getCaseName(), testCase.getExpectResponse(), actualResponse,
                    getComparedResult(testCase.getExpectResponse(), actualResponse), getTag(), tagName, new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new TestResult(testCase.getId(), testCase.getCaseName(), testCase.getExpectResponse(), null,
                TestResultConstant.ERROR, getTag(), tagName, new Date());
    }

    @Override
    @Transactional
    public List<TestResult> excute(List<TestCase> testCaseList, String tagName) {
        List<TestResult> testResults = new ArrayList<TestResult>();
        for (TestCase testCase : testCaseList) {
            testResults.add(excute(testCase, tagName));
        }
        testResultService.batchAdd(testResults);
        return testResults;
    }

    private String getComparedResult(String expectResponse, String actualResponse) {
        return expectResponse.equals(actualResponse) ? TestResultConstant.PASSED : TestResultConstant.FAILED;
    }

    private int getTag() {
        return testResultService.findMaxTag() + 1;
    }
}
