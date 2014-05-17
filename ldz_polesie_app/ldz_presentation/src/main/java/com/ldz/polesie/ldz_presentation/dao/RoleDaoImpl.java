/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.dao;

import com.ldz.polesie.entities.Role;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rola
 */
@Repository
public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

    @Override
    public List<Role> findAllRoles() {
        return getHibernateTemplate().loadAll(Role.class);
    }

    @Override
    public Role findRoleByName(String roleName) {
        List<Role> rolesFromDB = getHibernateTemplate().find("from Role as r where r.roleName = ? ", roleName);
        if(rolesFromDB.isEmpty()) return null;
        if(rolesFromDB.size() > 1) System.out.println("Znaleziono kilka wpisow w tabeli ROLE dla jednej nazwy - sprawdz konfigurację bazy danych");
        return rolesFromDB.get(0);
    }
    
}
