/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.JoyFlight;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * A concrete JPA DAO for joy flight activity entities
 * @author ian
 */
@Dependent
public class JoyFlightJpaDao implements ActivityDao<JoyFlight> {

    @PersistenceContext(unitName = "ChenGuoZangLinAIPAs2-ejbPU")
    private EntityManager em;

    /**
     * Selects all joy flight entities 
     * @return
     */
    @Override
    public List<JoyFlight> listActivities() {
        Query query = em.createNamedQuery("findAllJoyflights");
        List<JoyFlight> joyFlights = query.getResultList();
        return joyFlights;
    }

    /**
     * Selects a single joy flight activity
     * @param id
     * @return
     */
    @Override
    public JoyFlight getSingleActivity(long id) {
        return em.find(JoyFlight.class, id);
    }
}
