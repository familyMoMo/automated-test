package self.family.service.impl;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import self.family.service.TestVersionService;

/**
 * Created by fanmingli on 2015/8/25.
 */
public class TestVersionServiceImplTest extends TestCase {

    @Autowired
    private TestVersionService testVersionService;

    @Test
    public void testFindlatestVersion() throws Exception {
        System.out.println(testVersionService.findLatestVersion().getVersion());
    }

    @Test
    public void testFindAllVersions() throws Exception {
        System.out.println(testVersionService.findAllVersions().size());
    }
}