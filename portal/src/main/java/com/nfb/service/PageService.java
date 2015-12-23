package com.nfb.service;


import com.nfb.dao.IBatisBaseDao;
import com.nfb.entity.SimpleArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by dengfs on 2015/8/29.
 */
@Service
public class PageService {
    @Autowired
    IBatisBaseDao baseDao;

    public List<SimpleArticleEntity> getSimpleArticleByPage(Map param) throws SQLException {
        return baseDao.getList("page.getArticleByPage", param);
    }

    public SimpleArticleEntity getSimpleArticleById(Map param) throws SQLException {
        return (SimpleArticleEntity) baseDao.getObject("page.getArticleById", param);
    }
}
