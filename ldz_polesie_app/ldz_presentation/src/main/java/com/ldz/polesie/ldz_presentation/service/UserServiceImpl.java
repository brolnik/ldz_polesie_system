/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.service;

import com.ldz.polesie.entities.Role;
import com.ldz.polesie.ldz_presentation.dao.UserDao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Rola
 */
public class UserServiceImpl implements UserService, UserDetailsService {

    //injected by spring
    private UserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        
        com.ldz.polesie.entities.User userFromDb = userDao.findUser(login);
        
        if(userFromDb == null) {
            System.out.println("Nie znalazlem uzytkownika w bazie - normalnie rzuce wyjatkiem :) ale to pozniej :) ");
            throw new UsernameNotFoundException("Nie znaleziono użytkownika o podanym loginie");
        }
        
        String  userLogin     = userFromDb.getLogin();
        String  userPassword  = userFromDb.getPassword();
        
        System.out.println("login uzytkownika - " + userLogin);
        
        //to specify, we will have in system funcionality of activatation/deactivation accounts ?
        boolean isEnabled             = userFromDb.getIsActive();
        boolean accountNonExpired     = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked      = true;
        
        //Get all user's roles
        Set<Role> userRoles = userFromDb.getRoles();
        if(userRoles.isEmpty()) System.err.println("Uzytkownik nie posiada przypisanych rol - rzuc tutaj dedykowany blad !");
         
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        
        for(Role role : userRoles) {
            System.out.println("Rola uzytkownika - " + role.getRoleName());
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        
        UserDetails userDetails = new User(userLogin, userPassword, isEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return userDetails;
    }

    
    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    
}
