package com.aviationhub.presentation.backingbean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.aviationhub.domain.activitymanagement.ActivityHandlerLocal;
import com.aviationhub.domain.activitymanagement.entity.PilotTraining;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Zang
 */
@Named
@SessionScoped
public class ActivityBackingBean implements Serializable {

    @EJB
    private ActivityHandlerLocal activityhandler;
    @Inject
    private ShoppingCartBackingBean shoppingcart;
    private PilotTraining detail;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PilotTraining getDetail() {
        return detail;
    }

    public void setDetail(PilotTraining detail) {
        this.detail = detail;
    }

    public void viewdetails(long id1) {
        id = id1;
        detail = activityhandler.getPilotTrainingDetail(id);
    }

    public void book() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        int ind = Integer.parseInt(params.get("ind"));

        //debug logging info
        Logger log = Logger.getLogger(this.getClass().getName());
        log.log(Level.SEVERE, "Text: {0}", params.get("ind"));
        log.log(Level.SEVERE, "parsedInt: {0}", Integer.parseInt(params.get("ind")));
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(params.get("ind")));


        shoppingcart.addToCart(detail.getTimeSlots().get(ind));
        //return "";
    }
}
