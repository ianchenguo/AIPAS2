/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.PilotTraining;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ian
 */
@Dependent
public class PilotTrainingJpaDao implements ActivityDao<PilotTraining> {

    @PersistenceContext(unitName = "ChenGuoZangLinAIPAs2-ejbPU")
    private EntityManager em;

    /**
     * Selects all pilot training entities
     * @return
     */
    @Override
    public List<PilotTraining> listActivities() {
        Query query = em.createNamedQuery("findAllPilotTrainings");
        List<PilotTraining> pilotTrainings = query.getResultList();
        return pilotTrainings;
    }

    /**
     * Selects a single pilot training activity
     * @param id
     * @return
     */
    @Override
    public PilotTraining getSingleActivity(long id) {
        return em.find(PilotTraining.class, id);
    }
}
