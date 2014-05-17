/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.service;

import com.ldz.polesie.ldz_presentation.model.PlayerRegistrationModel;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rola
 */
@Service("playerService")
public interface PlayerService {
    
    public void createNewPlayer(PlayerRegistrationModel playerModel);
    
}
