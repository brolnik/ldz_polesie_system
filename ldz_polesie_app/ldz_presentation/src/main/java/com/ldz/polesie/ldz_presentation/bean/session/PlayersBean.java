/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldz.polesie.ldz_presentation.bean.session;

import com.ldz.polesie.entities.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Rola
 */
public class PlayersBean implements Serializable {

    private List<User> userList;
    private LDZControllerBean ldzControllerBean;
    private int dupa;

    @PostConstruct
    public void getAllUsers() {
        userList =  this.ldzControllerBean.getPlayerService().getAllUsers();
        System.out.println("userList contains "+userList.size()+" elements");
        dupa = userList.size();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public LDZControllerBean getLdzControllerBean() {
        return ldzControllerBean;
    }

    public void setLdzControllerBean(LDZControllerBean ldzControllerBean) {
        this.ldzControllerBean = ldzControllerBean;
    }

    public int getDupa() {
        return dupa;
    }

    public void setDupa(int dupa) {
        this.dupa = dupa;
    }
}
