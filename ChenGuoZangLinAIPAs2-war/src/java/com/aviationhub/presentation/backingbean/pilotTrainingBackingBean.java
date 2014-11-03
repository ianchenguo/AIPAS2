package com.aviationhub.presentation.backingbean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.aviationhub.domain.activitymanagement.ActivityHandlerLocal;
import com.aviationhub.domain.activitymanagement.entity.PilotTraining;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Zang
 */
@Named
@SessionScoped
public class pilotTrainingBackingBean implements Serializable{
    @EJB
    private ActivityHandlerLocal activityhandlerlocal;
    private List<PilotTraining> ps;
    
    public List<PilotTraining> viewList(){
        ps = activityhandlerlocal.listPilotTraining();
        return ps;
    }
    
    
         //Logout method associated with JdbcRealm 
    public String logout() throws ServletException {
        //Conventional way creating HttpServletRequest object
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        request.getSession().invalidate();  
        //Using built-in logout method to logout
        request.logout();
        
        //return to Login page afterwards
        return "home?faces-redirect=true";
    }
}
