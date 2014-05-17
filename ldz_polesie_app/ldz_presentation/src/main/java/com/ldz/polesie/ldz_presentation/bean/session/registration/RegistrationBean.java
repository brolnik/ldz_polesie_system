/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldz.polesie.ldz_presentation.bean.session.registration;

import com.ldz.polesie.ldz_presentation.bean.session.LDZControllerBean;
import com.ldz.polesie.ldz_presentation.model.PlayerRegistrationModel;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private PlayerRegistrationModel registrationModel = new PlayerRegistrationModel();
    private StreamedContent avatar;
    private List<String> positions = new ArrayList<String>();

    @PostConstruct
    public void initPositions() {
        positions.add("Bramkarz");
        positions.add("Obrońca");
        positions.add("Pomocnik");
        positions.add("Napastnik");
    }

    public String registerPlayer() {
        try {
            ldzControllerBean.getPlayerService().createNewPlayer(registrationModel);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "jeblo bledem", "jeblo bledem"));
            return "";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "zarejestrowalem uzytkownika", "zarejestrowalem uzytkownika"));
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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jestem tutaj", "Jestem tutaj"));
        System.out.println("Dupa jasiu, wywoluje metode");
        return event.getNewStep();
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "wgralem fotke", "wgralem fotke"));
        registrationModel.setPhoto(event.getFile().getContents());
        System.out.println("Zdjecie " + Arrays.toString(registrationModel.getPhoto()));
        InputStream io = new ByteArrayInputStream(registrationModel.getPhoto());
        avatar = new DefaultStreamedContent(io);
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

}
