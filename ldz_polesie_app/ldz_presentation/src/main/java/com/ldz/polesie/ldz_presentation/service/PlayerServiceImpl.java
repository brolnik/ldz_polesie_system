/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldz.polesie.ldz_presentation.service;

import com.ldz.polesie.entities.Player;
import com.ldz.polesie.entities.Role;
import com.ldz.polesie.entities.User;
import com.ldz.polesie.ldz_presentation.dao.PlayerDao;
import com.ldz.polesie.ldz_presentation.dao.RoleDao;
import com.ldz.polesie.ldz_presentation.dao.UserDao;
import com.ldz.polesie.ldz_presentation.model.PlayerRegistrationModel;
import com.ldz.polesie.ldz_presentation.utils.HashPassword;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rola
 */
public class PlayerServiceImpl implements PlayerService  {

    private UserDao   userDao;
    private PlayerDao playerDao;
    private RoleDao   roleDao;
    
    private final static String ROLE_USER = "ROLE_USER";

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createNewPlayer(PlayerRegistrationModel playerModel) throws NoSuchAlgorithmException {
        
        //Find role by name - by default we are creating only player with USER role, but administrator
        //will have opportunity change it or add new one (e.g. role admin)
        System.out.println("Player Model podczas tworzenia uzytkownika - " + playerModel.toString());
        
        Role roleFromDB = getUserRole(); 
        Set<Role> roles = new HashSet<>();
        
        //Create new user
        User user = new User();
        user.setIsActive(Boolean.FALSE);
        user.setLogin(playerModel.getLogin());
        user.setPassword(HashPassword.hashPassword(playerModel.getPassword()));

        Player player = new Player();
        player.setBirthDay(playerModel.getBirthDay());
        player.setEmail(playerModel.getEmail());
        player.setFirstname(playerModel.getFirstname());
        player.setNickname(playerModel.getNickname());
        player.setPhoneNumber(playerModel.getPhoneNumber());
        player.setPhoto(playerModel.getPhoto());
        player.setPlayedMatches(0);
        player.setPosition(playerModel.getPosition());
        player.setScoredGoals(0);
        player.setSurname(playerModel.getSurname());
        player.setTshirtNumber(playerModel.getTshirtNumber());
        player.setInjured(Boolean.FALSE);
        
        roles.add(roleFromDB);
        user.setPlayer(player);
        user.setRoles(roles);
        player.setUser(user);
        
        userDao.createOrUpdate(user);
    }
    
    @Transactional(readOnly = true)
    private Role getUserRole() {
        return roleDao.findByUniqueValue("roleName", ROLE_USER);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
