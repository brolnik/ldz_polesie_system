/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.entities.configuration;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Rola
 */
@Entity
@DiscriminatorValue(value = "POSITION")
public class ConfigurationPosition extends Configuration {
    
    private String position;

    @Column(name = "POSITION")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ConfigurationPosition(String position, Long id, String configName) {
        super(id, configName);
        this.position = position;
    }

    public ConfigurationPosition() {
    }

    @Override
    public String toString() {
        return "ConfigurationPosition{" + "position=" + position + '}';
    }    
}
