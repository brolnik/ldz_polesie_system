/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldz.polesie.ldz_presentation.bean.session.registration;

import com.ldz.polesie.entities.configuration.ConfigurationPosition;
import com.ldz.polesie.ldz_presentation.bean.session.LDZControllerBean;
import com.ldz.polesie.ldz_presentation.exceptions.PlayerException;
import com.ldz.polesie.ldz_presentation.model.PlayerRegistrationModel;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Rola
 */
public class RegistrationBean implements Serializable {

    private LDZControllerBean ldzControllerBean;
    private PlayerRegistrationModel registrationModel;
    private StreamedContent avatar;
    private List<String> configurationPositions;
    private List<Integer> configurationNumbers;

    @PostConstruct
    public void initPositions() {
        configurationPositions = ldzControllerBean.getConfigurationService().getPositions();
        configurationNumbers = ldzControllerBean.getConfigurationService().getAvailableTshirtNumbers();
    }

    public String registerPlayer() {
        try {
            ldzControllerBean.getPlayerService().createNewPlayer(registrationModel);
            configurationNumbers = ldzControllerBean.getConfigurationService().getAvailableTshirtNumbers();
        } catch (NoSuchAlgorithmException | PlayerException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
            return "";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Rejestracja nowego użytkownika zakończona sukcesem", "Rejestracja nowego użytkownika zakończona sukcesem"));
        return "";
    }

    public LDZControllerBean getLdzControllerBean() {
        return ldzControllerBean;
    }

    public void setLdzControllerBean(LDZControllerBean ldzControllerBean) {
        this.ldzControllerBean = ldzControllerBean;
    }

    public PlayerRegistrationModel getRegistrationModel() {
        return registrationModel;
    }

    public void setRegistrationModel(PlayerRegistrationModel registrationModel) {
        this.registrationModel = registrationModel;
    }

    public StreamedContent getAvatar() {
        return avatar;
    }

    public void setAvatar(StreamedContent avatar) {
        this.avatar = avatar;
    }

    public String onFlowProcess(FlowEvent event) {
        System.out.println("Going to the next step, step name is: - " + event.getNewStep());
        return event.getNewStep();
    }

    public void handleFileUpload(FileUploadEvent event) {
        System.out.println("Uploading new photo...");
        registrationModel.setPhoto(event.getFile().getContents());
        InputStream io = new ByteArrayInputStream(registrationModel.getPhoto());
        avatar = new DefaultStreamedContent(io);
        System.out.println("Photo uploaded...");
    }

    public List<String> getConfigurationPositions() {
        return configurationPositions;
    }

    public void setConfigurationPositions(List<String> configurationPositions) {
        this.configurationPositions = configurationPositions;
    }

    public List<Integer> getConfigurationNumbers() {
        return configurationNumbers;
    }

    public void setConfigurationNumbers(List<Integer> configurationNumbers) {
        this.configurationNumbers = configurationNumbers;
    }

}
