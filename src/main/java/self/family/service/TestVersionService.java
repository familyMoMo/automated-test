package self.family.service;

import self.family.entry.TestVersion;

import java.util.List;

/**
 * Created by Administrator on 2015/8/24.
 */
public interface TestVersionService {
    public List<TestVersion> findAllVersions();

    public boolean addVersion(TestVersion testVersion);
}
