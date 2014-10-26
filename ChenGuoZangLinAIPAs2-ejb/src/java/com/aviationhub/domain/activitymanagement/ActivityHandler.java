/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.Activity;
import com.aviationhub.domain.activitymanagement.entity.ActivityTypeEnum;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

/**
 *
 * @author ian
 */
@Stateless 
public class ActivityHandler implements ActivityHandlerLocal {

    @EJB @Preferred 
    ActivityDao activityDao;
    
    private ActivityTypeEnum activityType;

    /*
    @Override
    @Produces @Preferred
    public ActivityDao getActivityDao(@New JoyFlightJpaDao jfjd) {

        switch (activityType) {

            case JOYFLIGHT:
                return jfjd;

            default:
                return null;
        }

    }*/

    @Override
    public List<Activity> listActivities() {
        return activityDao.listActivities();
    }

    //getters and setters
    @Override
    public void setActivityType(ActivityTypeEnum activityType) {
        this.activityType = activityType;
    }

    
}
