package com.nfb.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @修改人：邓风森
 * @修改时间： 2015/3/11 17:34.
 */
@Component
public class IBatisBaseDao extends SqlMapClientDaoSupport {
    @Resource(name = "sqlMapClient")
    //通过bean名称注入
    private SqlMapClient sqlMapClient;

    @PostConstruct
        //完成sqlMapClient初始化工作
    void initSqlMapClient() {
        super.setSqlMapClient(sqlMapClient);
    }

}
