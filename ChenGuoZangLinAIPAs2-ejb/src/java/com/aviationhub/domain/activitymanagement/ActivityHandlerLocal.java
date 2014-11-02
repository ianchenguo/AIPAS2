/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.JoyFlight;
import com.aviationhub.domain.activitymanagement.entity.PilotTraining;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ian
 */
@Local
public interface ActivityHandlerLocal {

    public List<JoyFlight> listJoyFlights();

    public JoyFlight getJoyFlightDetail(Long id);

    public List<PilotTraining> listPilotTraining();

    public PilotTraining getPilotTrainingDetail(Long id);

    public boolean deductTimeSlotQuantity(Long timeSlotId, int subtractedQuantity);

}
