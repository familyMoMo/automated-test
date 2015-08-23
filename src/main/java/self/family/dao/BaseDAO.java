package self.family.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2015/8/22.
 */

public class BaseDAO {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    public SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
