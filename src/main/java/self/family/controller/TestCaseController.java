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

    @RequestMapping(value = "testResult")
    public String testResult(Model model) {
        model.addAttribute("tagNames", testResultService.findAllTagNames());
        return "testresult";
    }
    @RequestMapping(value = "addVersion")
    public String addVersion(TestVersion testVersion) {
        testVersionService.addVersion(testVersion);
        return "redirect:/testcase/index";
    }

    @ResponseBody
    @RequestMapping(value = "findPageByVersion")
    public PageVO<TestCase> findPageByVersion(String version, int page, int rows, HttpServletRequest request) {
        return testCaseService.findPageCaseByVersion(version, page, rows);
    }

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
    public String excute(String hideVersion, String tagName) {
        businessService.excute(testCaseService.findTestCasesByVersion(hideVersion), tagName);
        return "redirect:/testcase/testResult";
    }

    @ResponseBody
    @RequestMapping(value = "findPageResultByTagName")
    public PageVO<TestResult> findPageResultByTagName(String tagName, int page, int rows, HttpServletRequest request) {
        return testResultService.findPageResultByTagName(tagName, page, rows);
    }

    @RequestMapping(value = "removeTestResultsByTagName")
    public String removeTestResultsByTagName(String tagName) {
        System.out.println(tagName);
        testResultService.removeTestResultsByTagName(tagName);
        return "redirect:/testcase/testResult";
    }

    @ResponseBody
    @RequestMapping(value = "updateTestResult")
    public boolean updateTestResult(HttpServletRequest request) {
        String oper = request.getParameter("oper");
        if (oper.equalsIgnoreCase("del")) {
            return testResultService.batchRemove(request.getParameter("id").split(","));
        }
        return false;
    }
}
