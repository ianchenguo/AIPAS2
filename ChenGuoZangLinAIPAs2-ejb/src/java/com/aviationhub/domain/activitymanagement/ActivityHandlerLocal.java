/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.Activity;
import com.aviationhub.domain.activitymanagement.entity.ActivityTypeEnum;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ian
 */
@Local
public interface ActivityHandlerLocal {
    void setActivityType(ActivityTypeEnum activityType);
    List<Activity> listActivities();
    
    //public ActivityDao getActivityDao(@New JoyFlightJpaDao jfjd);
}
