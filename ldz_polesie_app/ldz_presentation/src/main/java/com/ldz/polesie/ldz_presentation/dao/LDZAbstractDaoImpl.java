/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldz.polesie.ldz_presentation.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Rola
 * @param <T>
 */
public abstract class LDZAbstractDaoImpl<T> extends HibernateDaoSupport implements LDZAbstractDao<T> {

    private final Class<T> type;

    @Override
    public <T> void createOrUpdate(T t) {
        getHibernateTemplate().saveOrUpdate(t);
        getHibernateTemplate().flush();
    }

    @Override
    public T findByUniqueValue(final String elemName, final Object value) {
        StringBuilder query = new StringBuilder();
        query.append("from ").append(type.getSimpleName()).append(" as x where ").append("x.").append(elemName).append(" = ?");
        List<T> results = getHibernateTemplate().find(query.toString(), value);
        if(results.size() <= 0) return null;
        return results.get(0);
    }

    @Override
    public List<T> getAll() {
        List<T> results = getHibernateTemplate().loadAll(type);
        return results;
    }

    public LDZAbstractDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }    
}
