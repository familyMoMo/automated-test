package self.family.dao;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fanmingli on 2015/8/25.
 */
public class TestVersionDAOTest extends BaseTest {

    @Autowired
    private TestVersionDAO testVersionDAO;

    @Test
    public void testFindAllVersions() throws Exception {
        System.out.println(testVersionDAO.findAllVersions().size());
    }

    public void testAddVersion() throws Exception {

    }

    @Test
    public void testFindLatestVersion() throws Exception {
        System.out.println(testVersionDAO.findLatestVersion().getVersion());
    }
}