package self.family.service.impl;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import self.family.dao.BaseTest;
import self.family.service.TestCaseService;

/**
 * Created by fanmingli on 2015/9/1.
 */
public class TestCaseServiceImplTest extends BaseTest {

    @Autowired
    private TestCaseService testCaseService;
    @Test
    public void testBatchRemove() throws Exception {
        String[] ids = new String[]{"8", "9"};
        System.out.println(testCaseService.batchRemove(ids));;
    }
}