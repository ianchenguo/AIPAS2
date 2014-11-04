/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.JoyFlight;
import com.aviationhub.domain.activitymanagement.entity.PilotTraining;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * A facade EJB for activity related logics
 *
 * @author ian
 */
@Stateless
public class ActivityHandler implements ActivityHandlerLocal {

    @Inject
    JoyFlightJpaDao joyFlightDao;
    @Inject
    PilotTrainingJpaDao pilotTrainingDao;

    /**
     * Lists all joy flight activities
     *
     * @return
     */
    @Override
    public List<JoyFlight> listJoyFlights() {
        return joyFlightDao.listActivities();
    }

    /**
     * Gets detail of a single joy flight activity
     *
     * @param id
     * @return
     */
    @Override
    public JoyFlight getJoyFlightDetail(Long id) {
        return joyFlightDao.getSingleActivity(id);
    }

    /**
     * Lists all pilot training activities
     *
     * @return
     */
    @Override
    public List<PilotTraining> listPilotTraining() {
        return pilotTrainingDao.listActivities();
    }

    /**
     * Gets detail of a single pilot training activity
     *
     * @param id
     * @return
     */
    @Override
    public PilotTraining getPilotTrainingDetail(Long id) {
        return pilotTrainingDao.getSingleActivity(id);
    }
}
