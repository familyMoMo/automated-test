package self.family.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.family.dao.TestVersionDAO;
import self.family.entry.TestVersion;
import self.family.service.TestVersionService;

import java.util.List;

/**
 * Created by Administrator on 2015/8/24.
 */
@Service
public class TestVersionServiceImpl implements TestVersionService {

    @Autowired
    private TestVersionDAO testVersionDAO;
    @Override
    public List<TestVersion> findAllVersions() {
        return testVersionDAO.findAllVersions();
    }

    @Override
    public boolean addVersion(TestVersion testVersion) {
        return testVersionDAO.addVersion(testVersion);
    }
}
