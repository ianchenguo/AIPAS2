/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.JoyFlight;
import com.aviationhub.domain.activitymanagement.entity.PilotTraining;
import com.aviationhub.domain.activitymanagement.entity.TimeSlot;
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
    @Inject
    TimeSlotJpaDao timeSlotDao;

    @Override
    public List<JoyFlight> listJoyFlights() {
        return joyFlightDao.listActivities();
    }

    @Override
    public JoyFlight getJoyFlightDetail(Long id) {
        return joyFlightDao.getSingleActivity(id);
    }

    @Override
    public List<PilotTraining> listPilotTraining() {
        return pilotTrainingDao.listActivities();
    }

    @Override
    public PilotTraining getPilotTrainingDetail(Long id) {
        return pilotTrainingDao.getSingleActivity(id);
    }

    @Override
    public boolean deductTimeSlotQuantity(Long timeSlotId, int subtractedQuantity) {

        TimeSlot ts = timeSlotDao.selectById(timeSlotId);
        int quantity = ts.getQuantity() - subtractedQuantity;
        if (quantity >= 0) {
            ts.setQuantity(quantity);
        } else {
            return false;
        }
        return true;
    }

}
