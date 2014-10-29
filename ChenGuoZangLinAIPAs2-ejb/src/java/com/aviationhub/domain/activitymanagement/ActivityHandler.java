/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.Activity;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ian
 */
@Stateless 
public class ActivityHandler implements ActivityHandlerLocal {

    @Inject
    JoyFlightJpaDao joyFlightDao;
    @Inject
    PilotTrainingJpaDao pilotTrainingDao;
    
    @Override
    public List<Activity> listJoyFlights() {
        return joyFlightDao.listActivities();
    }

    @Override
    public Activity getJoyFlightDetail(long id) {
        return joyFlightDao.getSingleActivity(id);
    }

    @Override
    public List<Activity> listPilotTraining() {
        return pilotTrainingDao.listActivities();
    }

    @Override
    public Activity getPilotTrainingDetail(long id) {
        return pilotTrainingDao.getSingleActivity(id);
    }
    
}
