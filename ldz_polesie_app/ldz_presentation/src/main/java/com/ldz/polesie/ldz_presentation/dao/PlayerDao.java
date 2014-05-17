/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.dao;

/**
 *
 * @author Rola
 */
public interface PlayerDao {
    
    public void createOrUpdatePlayer(com.ldz.polesie.entities.Player player, com.ldz.polesie.entities.User user);
    
}
