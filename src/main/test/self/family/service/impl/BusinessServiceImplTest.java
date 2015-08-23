package self.family.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import self.family.dao.BaseTest;
import self.family.entry.TestCase;
import self.family.service.BusinessService;

public class BusinessServiceImplTest extends BaseTest {

    @Autowired
    BusinessService businessService;

    @Test
    public void testExcute() throws Exception {
        TestCase testCase = new TestCase();
        testCase.setVersion("1.1.1");
        testCase.setCaseName("testcase1");
        testCase.setUrl("http://test.api.c-launcher.com/client/theme/newest/hottest.do");
        testCase.setRequestBody("country=&channelId=&pageSize=1&density=480&local=1");
        testCase.setContentType("application/x-www-form-urlencoded");
        testCase.setRequestMethod("post");
        testCase.setResponseResolver("json");
        testCase.setExpectResponse("{\"data\":{\"code\":100,\"themes\":[{\"orderNum\":1,\"_id\":\"54a8b1a40cf29ec97eddb9df\",\"id\":4354,\"title\":\"1219diy\",\"description\":\"test\",\"author\":\"fanfan\",\"category\":\"Animalstest \",\"tag\":\"\",\"downloads\":1,\"recommendTime\":1420341668672,\"inGooglePlay\":\"false\",\"googlePlayUrl\":\"\",\"jumpToGooglePlay\":\"false\",\"create_date\":\"2015-01-04\",\"thumbnail\":\"http://test.designer.c-launcher.com/resources/thumbnail/262/5493c4175c1bc29b673a4c3e/thumbnail_r_mobile_1419934690306.png\",\"price\":\"0.00\",\"url\":\"http://test.designer.c-launcher.com/resources/themes/cloud/3043c5fe-0e5b-45f2-8afa-a540f7d5b2fd/480.amr\",\"sizeStr\":\"488KB\",\"size\":500076,\"previews\":[{\"url\":\"http://test.designer.c-launcher.com/resources/preview/262/5493c4175c1bc29b673a4c3e/0_mobile_1419934692281.jpg\"},{\"url\":\"http://test.designer.c-launcher.com/resources/preview/262/5493c4175c1bc29b673a4c3e/1_mobile_1419934693506.jpg\"},{\"url\":\"http://test.designer.c-launcher.com/resources/preview/262/5493c4175c1bc29b673a4c3e/2_mobile_1419934694779.jpg\"},{\"url\":\"http://test.designer.c-launcher.com/resources/preview/262/5493c4175c1bc29b673a4c3e/3_mobile_1419934696041.jpg\"}]}]}}");
//        businessService.excute(testCase);

    }
}