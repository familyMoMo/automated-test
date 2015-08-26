package self.family.dao;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import self.family.entry.PageVO;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/8/22.
 */

public class BaseDAO<T> extends SqlSessionDaoSupport {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    protected <T extends Serializable> PageVO<T> getPage(String statement, Object entity, int page, int limit) {
        PageVO<T> pageVO = new PageVO<T>();
        List<T> itemList = this.getSqlSession().selectList(statement, entity, new RowBounds((page - 1) * limit, limit));
        MappedStatement mappedStatement = getSqlSession().getConfiguration().getMappedStatement(statement);
        final BoundSql boundSql = mappedStatement.getBoundSql(entity);
        Integer totalCount = getTotalCount(mappedStatement, boundSql);
        //如果计算数量的sql为空，用list.size代表总数量，若sql非空要专门去查一次总数量
        totalCount = (totalCount == null) ? itemList.size() : totalCount;
        pageVO.setLimit(limit);
        pageVO.setPage(page);
        pageVO.setRows(itemList);
        pageVO.setCount(totalCount);
        return pageVO;
    }

    private int getTotalCount(MappedStatement mappedStatement, BoundSql boundSql) {
        //原始SQL
        String originSql = boundSql.getSql();
        //去除order by,防止不必要的排序操作消耗数据库资源
        Pattern p = Pattern.compile("order\\s+by\\s+[\\S\\s]+",
                Pattern.CASE_INSENSITIVE);
        Matcher m;
        StringBuffer sb;
        int i = originSql.lastIndexOf(")");
        if (i > -1) {
            String fSql = originSql.substring(0, i + 1);
            String subSql = originSql.substring(i + 1, originSql.length());
            m = p.matcher(subSql);
            sb = new StringBuffer();
            while (m.find()) {
                m.appendReplacement(sb, "");
            }
            m.appendTail(sb);
            originSql = fSql + sb;
        } else {
            m = p.matcher(originSql);
            sb = new StringBuffer();
            while (m.find()) {
                m.appendReplacement(sb, "");
            }
            m.appendTail(sb);
            originSql = sb.toString();
        }
        //提升查询数量性能
        p = Pattern.compile("\\bSELECT\\b[\\s\\S]*?\\bFrom\\b", Pattern.CASE_INSENSITIVE);
        m = p.matcher(originSql);
        sb = new StringBuffer();
        if (m.find()) {
            m.appendReplacement(sb, "select count(*) from");
        }
        m.appendTail(sb);
        //String queryCountSql = "select count(*) from (" + originSql + ") as tempTable";
        String queryCountSql = sb.toString();
        Integer totalCount = null;
        DataSource ds = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ds = getSqlSession().getConfiguration().getEnvironment().getDataSource();
            conn = DataSourceUtils.getConnection(ds);
            ps = conn.prepareStatement(queryCountSql);
            //构造Mybatis参数处理器
            BoundSql newBoundSql = new BoundSql(getSqlSession().getConfiguration(), queryCountSql, boundSql.getParameterMappings(),
                    boundSql.getParameterObject());
            try {
                FieldUtils.writeField(newBoundSql, "metaParameters",
                        FieldUtils.readField(boundSql, "metaParameters", true), true);
            } catch (IllegalAccessException e) {
                return 0;
            }
            DefaultParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(),
                    newBoundSql);
            parameterHandler.setParameters(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                totalCount = rs.getInt(1);
            }

        } catch (SQLException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    DataSourceUtils.releaseConnection(conn, ds);
                }
            } catch (SQLException e) {
                throw new RuntimeException("关闭数据库连接出错");
            }
        }
        return totalCount;
    }

}
