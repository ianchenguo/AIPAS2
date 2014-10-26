/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import com.aviationhub.domain.activitymanagement.entity.Activity;
import java.util.List;

/**
 *
 * @author ian
 */
public interface ActivityDao {
    public List<Activity> listActivities();
    public Activity getSingleActivity(long id);
}
