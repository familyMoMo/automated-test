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
import java.util.Date;
import java.util.Enumeration;
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
    public PageVO<TestCase> findPageByVersion(String version, int page, int rows, HttpServletRequest request) {
        return testCaseService.findPageCaseByVersion(version, page, rows);
    }



    @RequestMapping(value = "findTestCaseById")
    public TestCase findTestCaseById(int id) {
        return testCaseService.findTestCaseById(id);
    }

    @RequestMapping(value = "addTestCase")
    public boolean addTestCase(TestCase testCase) {
        return testCaseService.addTestCase(testCase);
    }

//    @RequestMapping(value = "removeTestCase")
//    public boolean removeTestCase(int id) {
//        return testCaseService.removeTestCase(id);
//    }

    @ResponseBody
    @RequestMapping(value = "updateTestCase")
    public boolean updateTestCase(HttpServletRequest request) {
        String oper = request.getParameter("oper");
        if (oper.equalsIgnoreCase("edit")) {
            TestCase testCase = new TestCase(Integer.parseInt(request.getParameter("id")), request.getParameter("caseName"), request.getParameter("url"),
                    request.getParameter("requestMethod"), request.getParameter("requestHeader"), request.getParameter("requestCookie"),
                    request.getParameter("requestBody"), request.getParameter("requestEncoding"), request.getParameter("contentType"),
                    request.getParameter("responseResolver"), request.getParameter("expectResponse"), request.getParameter("description"),
                    new Date());
            return testCaseService.updateTestCase(testCase);
        } else if (oper.equalsIgnoreCase("add")) {
            TestCase testCase = new TestCase(request.getParameter("version"), request.getParameter("caseName"), request.getParameter("url"),
                    request.getParameter("requestMethod"), request.getParameter("requestHeader"), request.getParameter("requestCookie"),
                    request.getParameter("requestBody"), request.getParameter("requestEncoding"), request.getParameter("contentType"),
                    request.getParameter("responseResolver"), request.getParameter("expectResponse"), request.getParameter("description"),
                    new Date(), new Date());
            return testCaseService.addTestCase(testCase);
        } else if (oper.equalsIgnoreCase("del")) {
            return testCaseService.batchRemove(request.getParameter("id").split(","));
        }
        return false;
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
