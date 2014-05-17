/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Rola
 */
public class PlayerRegistrationModel implements Serializable {
    
    private String  login;
    private String  password;
    private String  firstname;
    private String  surname;
    private Date    birthDay;
    private String  position;
    private String  nickname;
    private String  email;
    private String  phoneNumber;
    private byte[]  photo;
    private Integer tshirtNumber;
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Integer getTshirtNumber() {
        return tshirtNumber;
    }

    public void setTshirtNumber(Integer tshirtNumber) {
        this.tshirtNumber = tshirtNumber;
    }

    @Override
    public String toString() {
        return "PlayerRegistrationModel{" + "login=" + login + ", password=" + password + ", firstname=" + firstname + ", surname=" + surname + ", birthDay=" + birthDay + ", position=" + position + ", nickname=" + nickname + ", email=" + email + ", phoneNumber=" + phoneNumber + ", photo=" + Arrays.toString(photo) + ", tshirtNumber=" + tshirtNumber + '}';
    }
   
}
