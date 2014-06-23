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
@DiscriminatorValue(value = "NUMBER")
public class ConfigurationNumber extends Configuration {
    
    private Integer number;
    private Boolean isUsed;

    @Column(name = "TSHIRT_NUMBER", unique = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column(name = "IS_USED")
    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }

    public ConfigurationNumber(Integer number, Boolean isUsed, Long id, String configName) {
        super(id, configName);
        this.number = number;
        this.isUsed = isUsed;
    }

    public ConfigurationNumber() {
    }

    @Override
    public String toString() {
        return "ConfigurationNumber{" + "number=" + number + ", isUsed=" + isUsed + '}';
    }
}
