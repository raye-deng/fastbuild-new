package com.nfb.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @修改人：邓风森
 * @修改时间： 2015/3/11 17:34.
 */
@Repository
public class IBatisBaseDao extends SqlMapClientDaoSupport {
    @Resource(name = "sqlMapClient")
    //通过bean名称注入
    private SqlMapClient sqlMapClient;

    @PostConstruct
        //完成sqlMapClient初始化工作
    void initSqlMapClient() {
        super.setSqlMapClient(sqlMapClient);
    }

    public int deleteForBatch(String statementId, List paramList)
            throws SQLException {
        getSqlMapClient().startBatch();
        for (Iterator i = paramList.iterator(); i.hasNext(); ) {
            getSqlMapClientTemplate().delete(statementId, i.hasNext());
        }
        return getSqlMapClient().executeBatch();
    }

    public Integer getCount(String statementId, Object paramObject)
            throws SQLException {
        return (Integer) getSqlMapClientTemplate().queryForObject(statementId,
                paramObject);
    }

    public List getList(String statementId, Object paramObject)
            throws SQLException {
        return getSqlMapClientTemplate().queryForList(statementId, paramObject);
    }

    public Object getObject(String statementId, Object paramObject)
            throws SQLException {
        return getSqlMapClientTemplate().queryForObject(statementId,
                paramObject);
    }

    public int insertForBatch(String statementId, List paramList)
            throws SQLException {
        getSqlMapClient().startBatch();
        for (Object obj : paramList) {
            getSqlMapClientTemplate().insert(statementId, obj);
        }
        return getSqlMapClient().executeBatch();
    }

    public int updateForBatch(String statementId, List paramList)
            throws SQLException {
        getSqlMapClient().startBatch();
        for (Object obj : paramList) {
            getSqlMapClientTemplate().update(statementId, obj);
        }
        return getSqlMapClient().executeBatch();
    }

    public int delete(String statementId, Object paramObject)
            throws SQLException {
        return getSqlMapClientTemplate().delete(statementId, paramObject);
    }

    public Object insert(String statementId, Object paramObject)
            throws SQLException {
        return getSqlMapClientTemplate().insert(statementId, paramObject);
    }

    public int update(String statementId, Object paramObject)
            throws SQLException {
        return getSqlMapClientTemplate().update(statementId, paramObject);
    }
}
