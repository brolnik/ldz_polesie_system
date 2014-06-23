/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.bean.session;

import com.ldz.polesie.ldz_presentation.service.ConfigurationService;
import com.ldz.polesie.ldz_presentation.service.PlayerService;
import com.ldz.polesie.ldz_presentation.service.UserService;
import java.io.Serializable;

/**
 *
 * @author Rola
 */
public class LDZControllerBean implements Serializable {
    
    private PlayerService        playerService;
    private UserService          userService;
    private ConfigurationService configurationService;

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

    public ConfigurationService getConfigurationService() {
        return configurationService;
    }

    public void setConfigurationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }    
}
