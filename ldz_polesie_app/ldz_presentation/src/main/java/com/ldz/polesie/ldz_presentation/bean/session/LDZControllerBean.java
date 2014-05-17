/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.bean.session;

import com.ldz.polesie.ldz_presentation.service.PlayerService;
import com.ldz.polesie.ldz_presentation.service.UserService;
import java.io.Serializable;

/**
 *
 * @author Rola
 */
public class LDZControllerBean implements Serializable {
    
    private PlayerService playerService;
    private UserService   userService;

    public PlayerService getPlayerService() {
        return playerService;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }    
}
