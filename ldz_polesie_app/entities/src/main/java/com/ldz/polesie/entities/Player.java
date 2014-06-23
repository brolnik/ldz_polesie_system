/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldz.polesie.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

/**
 *
 * @author Rola
 */
@Entity
@Table(name = "PLAYER_T")
public class Player implements Serializable {

    private Long playerId;
    private String firstname;
    private String surname;
    private User user;
    private Date birthDay;
    private Boolean injured;
    private String position;
    private String nickname;
    private Integer scoredGoals;
    private Integer playedMatches;
    private String email;
    private String phoneNumber;
    private byte[] photo;
    private Integer tshirtNumber;

    @Id
    @Column(name = "PLAYER_ID", unique = true, nullable = false)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user"))
    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    @Column(name = "FIRSTNAME", nullable = false)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "SURNAME", nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "BIRTHDAY", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Column(name = "INJURED", nullable = false)
    public Boolean getInjured() {
        return injured;
    }

    public void setInjured(Boolean injured) {
        this.injured = injured;
    }

    @Column(name = "POSITION", nullable = false)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "NICKNAME", nullable = false, length = 255)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Column(name = "SCORED_GOALS", nullable = false)
    public Integer getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(Integer scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column(name = "PLAYED_MATCHES", nullable = false)
    public Integer getPlayedMatches() {
        return playedMatches;
    }

    public void setPlayedMatches(Integer playedMatches) {
        this.playedMatches = playedMatches;
    }

    @Column(name = "PHOTO")
    @Type(type = "org.hibernate.type.BinaryType")
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Column(name = "EMAIL", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PHONE_NUMBER", nullable = false, unique = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "TSHIRT_NUMBER")
    public Integer getTshirtNumber() {
        return tshirtNumber;
    }

    public void setTshirtNumber(Integer tshirtNumber) {
        this.tshirtNumber = tshirtNumber;
    }

    public Player() {
    }

    public Player(Long playerId, String firstname, String surname, User user, Date birthDay, Boolean injured, String position, String nickname, Integer scoredGoals, Integer playedMatches, String email, String phoneNumber, byte[] photo, Integer tshirtNumber) {
        this.playerId = playerId;
        this.firstname = firstname;
        this.surname = surname;
        this.user = user;
        this.birthDay = birthDay;
        this.injured = injured;
        this.position = position;
        this.nickname = nickname;
        this.scoredGoals = scoredGoals;
        this.playedMatches = playedMatches;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
        this.tshirtNumber = tshirtNumber;
    }
}
