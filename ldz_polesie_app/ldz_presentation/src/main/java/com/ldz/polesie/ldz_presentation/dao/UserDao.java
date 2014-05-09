/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.dao;

import java.util.List;

/**
 *
 * @author Rola
 */
public interface UserDao {
    
    public com.ldz.polesie.entities.User       findUser(String login);
    public List<com.ldz.polesie.entities.User> findAllUsers();
    
}
