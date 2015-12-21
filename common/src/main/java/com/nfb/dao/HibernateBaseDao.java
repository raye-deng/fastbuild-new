package com.nfb.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 基础操作Dao  此dao类封装了hibernateTemplate，完成基础的增删改查
 *
 * @author 邓风森
 */
@Transactional(rollbackFor = Exception.class, timeout = 300)
@Component
public class HibernateBaseDao {
    private HibernateTemplate hibernateTemplate;

    // 添加
    public void save(Object o) {
        hibernateTemplate.save(o);
    }

    // 修改
    public void update(Object o) {
        hibernateTemplate.update(o);
    }

    // 修改(在session中已存在这个对象的修改)
    public void merge(Object o) {
        hibernateTemplate.merge(o);
    }

    // 删除对象
    public void delete(Object o) {
        hibernateTemplate.delete(o);
    }

    // 根据ID获取对象
    public Object queryById(Class<?> c, Serializable id) {
        return hibernateTemplate.get(c, id);
    }

    // 根据ID删除对象
    public void deleteById(Class<?> c, Serializable id) {
        delete(queryById(c, id));
    }

    // 获取所有的记录
    public List<?> getAll(Class<?> c) {
        String hql = "from" + c.getName();
        return hibernateTemplate.find("from " + c.getName());
    }

    // 批量修改
    public void bulkUpdate(String hql, Object... objects) {
        hibernateTemplate.bulkUpdate(hql, objects);
    }

    // 得到唯一值
    public Object getUnique(final String hql, final Object... objects) {
        return hibernateTemplate.execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                if (objects != null)
                    for (int i = 0; i < objects.length; i++)
                        query.setParameter(i, objects[i]);
                return query.uniqueResult();
            }
        });
    }

    // 分页查询
    public List<?> pageQuery(final String hql, final Integer page, final Integer size, final Object... objects) {
        return hibernateTemplate.execute(new HibernateCallback<List>() {

            public List doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                if (objects != null)
                    for (int i = 0; i < objects.length; i++) {
                        query.setParameter(i, objects[i]);
                    }
                if (page != null && size != null)
                    query.setFirstResult((page - 1) * size).setMaxResults(size);
                return query.list();
            }
        });
    }

    // 不分页查询
    public List<?> pageQuery(String hql, Object... objects) {
        return pageQuery(hql, null, null, objects);
    }

    /**
     * 保存或者更新对象
     *
     * @param o
     */
    public void saveOrUpdate(Object o) {
        if (o != null)
            hibernateTemplate.saveOrUpdate(o);
    }

    /**
     * 根据hql语句执行更新
     *
     * @param hql
     * @param objects 参数
     */
    public void update(final String hql, final Object... objects) {
        hibernateTemplate.execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                if (objects != null)
                    for (int i = 0; i < objects.length; i++)
                        query.setParameter(i, objects[i]);
                return query.executeUpdate();
            }
        });
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

}
