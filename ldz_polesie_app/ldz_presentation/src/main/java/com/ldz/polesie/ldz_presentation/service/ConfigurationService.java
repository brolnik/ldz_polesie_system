/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.service;

import com.ldz.polesie.entities.configuration.Configuration;
import com.ldz.polesie.ldz_presentation.exceptions.PlayerException;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rola
 */
@Service("configurationService")
public interface ConfigurationService {
    
    public List<Configuration> getAllConfig();
    public List<? extends Configuration> getConfig(String key);
    public List<String> getPositions();
    public Map<Integer, Boolean> getTshirtNumbers();
    public List<Integer> getAvailableTshirtNumbers();
    public Boolean isNumberStillAvailable(final Integer number) throws PlayerException;
    public void updateTshirtNumberConfiguration(final Integer number) throws PlayerException;
    
}
