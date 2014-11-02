/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.Activity;
import com.aviationhub.domain.activitymanagement.entity.TimeSlot;

/**
 *
 * @author ian
 */
public interface TimeSlotDao {

    public TimeSlot selectById(Long id);

    public void update(TimeSlot timeSlot);
}
