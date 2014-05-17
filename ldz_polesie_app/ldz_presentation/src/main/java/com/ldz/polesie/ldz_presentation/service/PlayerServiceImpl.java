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
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void createNewPlayer(PlayerRegistrationModel playerModel) {
        
        //Find role by name - by default we are creating only player with USER role, but administrator
        //will have opportunity change it or add new one (e.g. role admin)
        System.out.println("Player Model podczas tworzenia uzytkownika - " + playerModel.toString());
        
        Role roleFromDB = roleDao.findRoleByName(ROLE_USER);
        
        Set<Role> roles = new HashSet<>();
        roles.add(roleFromDB);
        
        //Create new user
        User user = new User();
        user.setIsActive(Boolean.FALSE);
        user.setLogin(playerModel.getLogin());
        user.setPassword(playerModel.getPassword());
        user.setRoles(roles);
        
        //Create new player
        Player player = new Player();
        //player.setBirthDay(); // dopisz formater dat
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
        
        playerDao.createOrUpdatePlayer(player, user);
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
