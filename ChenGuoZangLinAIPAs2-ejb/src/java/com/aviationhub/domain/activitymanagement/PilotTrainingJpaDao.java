/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.Activity;
import com.aviationhub.domain.activitymanagement.entity.PilotTraining;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ian
 */
@Stateless
@LocalBean
public class PilotTrainingJpaDao implements ActivityDao {

    @PersistenceContext(unitName = "ChenGuoZangLinAIPAs2-ejbPU")
    private EntityManager em;

    @Override
    public List<Activity> listActivities() {
        Query query = em.createNamedQuery("findAllPilotTrainings");
        List<Activity> pilotTrainings = query.getResultList();
        return pilotTrainings;
    }

    @Override
    public Activity getSingleActivity(long id) {
        return em.find(PilotTraining.class, id);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}