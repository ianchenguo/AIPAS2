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
 * A local interface for the facade EJB of activity related logics
 *
 * @author ian
 */
@Local
public interface ActivityHandlerLocal {

    /**
     * Lists all joy flight activities
     *
     * @return
     */
    public List<JoyFlight> listJoyFlights();

    /**
     * Gets detail of a single joy flight activity
     *
     * @param id
     * @return
     */
    public JoyFlight getJoyFlightDetail(Long id);

    /**
     * Lists all pilot training activities
     *
     * @return
     */
    public List<PilotTraining> listPilotTraining();

    /**
     * Gets detail of a single pilot training activity
     *
     * @param id
     * @return
     */
    public PilotTraining getPilotTrainingDetail(Long id);
}
