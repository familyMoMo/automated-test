package self.family.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import self.family.entry.PageVO;
import self.family.entry.TestCase;
import self.family.entry.TestResult;
import self.family.entry.TestVersion;
import self.family.service.BusinessService;
import self.family.service.TestCaseService;
import self.family.service.TestResultService;
import self.family.service.TestVersionService;
import self.family.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by fanmingli on 2015/8/25.
 */
@Controller
@RequestMapping(value = "testcase")
public class TestCaseController {

    @Autowired
    private TestVersionService testVersionService;

    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private TestResultService testResultService;

    @Autowired
    private BusinessService businessService;

    @RequestMapping(value = "index")
    public String index(Model model) {
        model.addAttribute("versions", testVersionService.findAllVersions());
        return "testcase";
    }

    @ResponseBody
    @RequestMapping(value = "findAllVersions")
    public List<TestVersion> findAllVersions() {
        return testVersionService.findAllVersions();
    }

    @ResponseBody
    @RequestMapping(value = "addVersion")
    public boolean addVersion(TestVersion testVersion) {
        return testVersionService.addVersion(testVersion);
    }

    @ResponseBody
    @RequestMapping(value = "findTestCasesByVersion")
    public List<TestCase> findTestCasesByVersion(String version) {
        return testCaseService.findTestCasesByVersion(version);
    }

//    @ResponseBody
//    @RequestMapping(value = "findPageByVersion")
//    public PageVO<TestCase> findPageByVersion(String version, int pageNumber, int pageSize, HttpServletRequest request) throws IOException {
//
//        return testCaseService.findPageCaseByVersion(version, pageNumber, pageSize);
//    }

    @ResponseBody
    @RequestMapping(value = "findPageByVersion")
    public PageVO<TestCase> findPageByVersion(String version, HttpServletRequest request) {
        // 取得当前页数,注意这是jqgrid自身的参数
        // 取得每页显示行数，,注意这是jqgrid自身的参数
        return testCaseService.findPageCaseByVersion(version, Integer.parseInt(request.getParameter("page")), Integer.parseInt(request.getParameter("rows")));
    }

    @RequestMapping(value = "findTestCaseById")
    public TestCase findTestCaseById(int id) {
        return testCaseService.findTestCaseById(id);
    }

    @RequestMapping(value = "addTestCase")
    public boolean addTestCase(TestCase testCase) {
        return testCaseService.addTestCase(testCase);
    }

    @RequestMapping(value = "removeTestCase")
    public boolean removeTestCase(int id) {
        return testCaseService.removeTestCase(id);
    }

    @RequestMapping(value = "updateTestCase")
    public boolean updateTestCase(TestCase testCase) {
        return testCaseService.updateTestCase(testCase);
    }

    @RequestMapping(value = "excuteTestCase")
    public List<TestResult> excute(List<TestCase> testCaseList, String tagName) {
        return businessService.excute(testCaseList, tagName);
    }

    @RequestMapping(value = "findTestResultsByTag")
    public List<TestResult> findTestResultsByTag(int tag) {
        return testResultService.findTestResultsByTag(tag);
    }

    @RequestMapping(value = "removeTestResultsByTag")
    public boolean removeTestResultsByTag(int tag) {
        return testResultService.removeTestResultsByTag(tag);
    }


}
