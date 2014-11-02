/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.TimeSlot;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ian
 */
@Dependent
public class TimeSlotJpaDao implements TimeSlotDao {

    @PersistenceContext(unitName = "ChenGuoZangLinAIPAs2-ejbPU")
    private EntityManager em;

    @Override
    public TimeSlot selectById(Long id) {
        return em.find(TimeSlot.class, id);
    }

    @Override
    public void update(TimeSlot timeSlot) {
        em.merge(timeSlot);
    }

}
