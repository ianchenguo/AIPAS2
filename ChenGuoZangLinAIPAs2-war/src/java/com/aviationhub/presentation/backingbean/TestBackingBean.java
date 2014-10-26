/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.backingbean;

import com.aviationhub.domain.activitymanagement.ActivityHandlerLocal;
import com.aviationhub.domain.activitymanagement.entity.Activity;
import com.aviationhub.domain.activitymanagement.entity.ActivityTypeEnum;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ian
 */
@Named(value = "testBackingBean")
@SessionScoped
public class TestBackingBean implements Serializable{

    //ActivityTypeEnum activityType;
    
    
    public TestBackingBean() {
    }
    
    @EJB
    ActivityHandlerLocal activityHandler;
    
    public List<Activity> listActivities() {
        return activityHandler.listActivities();
    }

    public void setActivityType(ActivityTypeEnum activityTypeEnum) {
        activityHandler.setActivityType(activityTypeEnum);
    }
}
