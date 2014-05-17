/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.dao;

import com.ldz.polesie.entities.Player;
import com.ldz.polesie.entities.User;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rola
 */
@Repository
public class PlayerDaoImpl extends HibernateDaoSupport implements PlayerDao {

    @Override
    public void createOrUpdatePlayer(Player player, User user) {
        
        getHibernateTemplate().saveOrUpdate(user);
        getHibernateTemplate().flush();

        User user2 = (User) getHibernateTemplate().load(User.class, user.getId());

        System.out.println("User_id2 " + user2.getId());

        player.setUser(user2);
        getHibernateTemplate().merge(player);
        getHibernateTemplate().flush();
    }
    
}
