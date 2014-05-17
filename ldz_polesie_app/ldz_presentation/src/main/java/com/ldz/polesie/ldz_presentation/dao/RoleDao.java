/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.dao;

import com.ldz.polesie.entities.Role;
import java.util.List;

/**
 *
 * @author Rola
 */
public interface RoleDao {
    
    public List<Role> findAllRoles();
    public Role findRoleByName(String roleName);
    
}
