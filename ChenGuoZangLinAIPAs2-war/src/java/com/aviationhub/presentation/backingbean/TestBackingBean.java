/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.backingbean;

import com.aviationhub.domain.activitymanagement.ActivityHandlerLocal;
import com.aviationhub.domain.activitymanagement.entity.Activity;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ian
 */
@Named(value = "testBackingBean")
@SessionScoped
public class TestBackingBean implements Serializable {

    //ActivityTypeEnum activityType;
    public TestBackingBean() {
    }

    @EJB
    ActivityHandlerLocal activityHandler;

    public List<Activity> listJoyFlights() {
        return activityHandler.listJoyFlights();
    }

    public List<Activity> listPilotTraining() {
        return activityHandler.listPilotTraining();
    }

    public Activity getJoyFlightDetail(long id) {
        return activityHandler.getJoyFlightDetail(id);
    }

    public Activity getPilotTrainingDetail(long id) {
        return activityHandler.getPilotTrainingDetail(id);
    }

}
