/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldz.polesie.ldz_presentation.service;

import com.ldz.polesie.entities.configuration.Configuration;
import com.ldz.polesie.entities.configuration.ConfigurationNumber;
import com.ldz.polesie.entities.configuration.ConfigurationPosition;
import com.ldz.polesie.ldz_presentation.dao.configuration.ConfigurationDAO;
import com.ldz.polesie.ldz_presentation.exceptions.PlayerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rola
 */
public class ConfigurationServiceImpl implements ConfigurationService {

    private ConfigurationDAO configurationDao;
    private List<Configuration> configurations;
    private Map<String, List<? extends Configuration>> globalConfiguration;
    private final String NUMBERS   = "numbers";
    private final String POSITIONS = "positions";

    @Override
    @Transactional(readOnly = true)
    public List<Configuration> getAllConfig() {
        return configurationDao.getAll();
    }

    @Autowired
    public void setConfigurationDao(ConfigurationDAO configurationDao) {
        this.configurationDao = configurationDao;
    }

    public void initConfiguration() {
        configurations = configurationDao.getAll();
        prepareConfigurationMap();
        printGlobalConfiguration();
    }

    private void printGlobalConfiguration() {
        for (Entry entry : globalConfiguration.entrySet()) {
            System.out.println("Entry Key: " + entry.getKey().toString());
            List<? extends Configuration> configs = (List<? extends Configuration>) entry.getValue();
            for (Configuration c : configs) {
                if (c.getConfigName().equals(NUMBERS)) {
                    ConfigurationNumber cn = (ConfigurationNumber) c;
                    System.out.println("\t" + cn.toString());
                } else if (c.getConfigName().equals(POSITIONS)) {
                    ConfigurationPosition cn = (ConfigurationPosition) c;
                    System.out.println("\t" + cn.toString());
                }
            }
        }
    }

    private void prepareConfigurationMap() {

        if (globalConfiguration == null) {
            globalConfiguration = new HashMap<>();
        }

        List<String> configurationNames = new ArrayList<>();
        for (Configuration c : configurations) {
            configurationNames.add(c.getConfigName());
        }
        Set<String> uniqueConfigurationNames = new HashSet<>(configurationNames);

        for (String configName : uniqueConfigurationNames) {
            List configurationElements = new ArrayList<>();
            for (Configuration config : configurations) {
                if (configName.equals(config.getConfigName()) && config.getConfigName().equals(NUMBERS)) {
                    ConfigurationNumber configurationNumber = (ConfigurationNumber) config;
                    configurationElements.add(configurationNumber);
                } else if (configName.equals(config.getConfigName()) && config.getConfigName().equals(POSITIONS)) {
                    ConfigurationPosition configurationPosition = (ConfigurationPosition) config;
                    configurationElements.add(configurationPosition);
                }
            }
            globalConfiguration.put(configName, configurationElements);
        }
    }

    @Override
    public List<? extends Configuration> getConfig(String key) {
        return globalConfiguration.get(key);
    }

    @Override
    public List<String> getPositions() {
        List<ConfigurationPosition> configurationPositions = (List<ConfigurationPosition>) getConfig(POSITIONS);
        List<String> positions = new ArrayList<>();
        for (ConfigurationPosition config : configurationPositions) {
            positions.add(config.getPosition());
        }
        return positions;
    }

    @Override
    public Map<Integer, Boolean> getTshirtNumbers() {
        List<ConfigurationNumber> configurationNumbers = (List<ConfigurationNumber>) getConfig(NUMBERS);
        Map<Integer, Boolean> numbers = new HashMap<>();
        for (ConfigurationNumber config : configurationNumbers) {
            numbers.put(config.getNumber(), config.getIsUsed());
        }
        return numbers;
    }

    @Override
    public List<Integer> getAvailableTshirtNumbers() {
        List<ConfigurationNumber> configurationNumbers = (List<ConfigurationNumber>) getConfig(NUMBERS);
        List<Integer> numbers = new ArrayList<>();
        for (ConfigurationNumber config : configurationNumbers) {
            if (Objects.equals(config.getIsUsed(), Boolean.FALSE)) {
                numbers.add(config.getNumber());
            }
        }
        return numbers;
    }

    @Override
    public Boolean isNumberStillAvailable(final Integer number) throws PlayerException{
        if (number == null) {
            throw PlayerException.invalidData();
        }
        Boolean isAvailable = Boolean.TRUE;
        List<ConfigurationNumber> configurationNumbers = (List<ConfigurationNumber>) getConfig(NUMBERS);
        for (ConfigurationNumber config : configurationNumbers) {
            if (number.compareTo(config.getNumber()) == 0) {
                if (Objects.equals(config.getIsUsed(), Boolean.TRUE)) {
                    isAvailable = Boolean.FALSE;
                    break;
                }
            }
        }
        return isAvailable;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateTshirtNumberConfiguration(final Integer number) throws PlayerException {
        if (number == null) {
           throw PlayerException.invalidData();
        }

        System.out.println("Refreshing globalConfiguration...");
        for (Entry entry : globalConfiguration.entrySet()) {
            System.out.println("Parsing configuration: " + (String) entry.getKey());
            List<? extends Configuration> configs = (List<? extends Configuration>) entry.getValue();
            for (Configuration c : configs) {
                if (c.getConfigName().equals(NUMBERS)) {
                    ConfigurationNumber cn = (ConfigurationNumber) c;
                    if (cn.getNumber().compareTo(number) == 0) {
                        System.out.println("Updating globalConfiguration...\n Number: " + number.toString() + "is used now");
                        cn.setIsUsed(Boolean.TRUE);
                        break;
                    }
                }
            }
        }
        System.out.println("GlobalConfiguration refreshed...");
        System.out.println("Updating configuration in DB...");
        for (Configuration config : configurations) {
            if (config.getConfigName().equals(NUMBERS)) {
                ConfigurationNumber cn = (ConfigurationNumber) config;
                if (cn.getNumber().compareTo(number) == 0) {
                    System.out.println("Updating globalConfiguration...\n Number: " + number.toString() + "is used now");
                    cn.setIsUsed(Boolean.TRUE);
                    configurationDao.createOrUpdate(config);
                }
            }
        }
        System.out.println("Configuration in DB updated...");
    }
}
