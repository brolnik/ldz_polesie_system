/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldz.polesie.ldz_presentation.bean.login;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Rola
 */
public class LoginUserBean implements Serializable {

    private AuthenticationManager authenticationManager;
    private LoginUserDetailsBean loginUserDetailsBean;

    public String login() {

        try {

            Authentication request = new UsernamePasswordAuthenticationToken(loginUserDetailsBean.getLogin(), loginUserDetailsBean.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);

        } catch (AuthenticationException ex) {
            System.out.println("rzucony blad z dupy " + ex.getMessage() + ex.getLocalizedMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Niepoprawny login/haslo lub uzytkowik zostal zablokowany", "Niepoprawny login/haslo lub uzytkowik zostal zablokowany"));
            return "";
        }

        System.out.println("po autoryzacji " + SecurityContextHolder.getContext().getAuthentication().getName());

        return "logged";
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public LoginUserDetailsBean getLoginUserDetailsBean() {
        return loginUserDetailsBean;
    }

    public void setLoginUserDetailsBean(LoginUserDetailsBean loginUserDetailsBean) {
        this.loginUserDetailsBean = loginUserDetailsBean;
    }

}
