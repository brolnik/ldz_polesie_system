/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.dao;

import com.ldz.polesie.entities.User;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rola
 * 
 *  
 */

@Repository
public class IUserDao extends HibernateDaoSupport implements UserDao {

    @Override
    public User findUser(String login) {
        
        if(StringUtils.isBlank(login))
        {
            //TODO - throw dedicated exception
            return null;
        }
        
        List<User> usersFromDB = getHibernateTemplate().find("from User as u where u.login = ? ", login);
        
        if(usersFromDB.isEmpty())  return null;
        //TODO - Throw here dedicated exception 
        if(usersFromDB.size() > 1) return null;
        
        //usersFromDB has only one element
        User userFromDB = usersFromDB.get(0);
        return userFromDB;
    }

    @Override
    public List<User> findAllUsers() {
        return getHibernateTemplate().loadAll(User.class);
    }
    
}
