/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import java.util.List;

/**
 * A DAO interface for activity entities
 * @author ian
 * @param <A>
 */
public interface ActivityDao<A> {

    /**
     * Selects all activities of an activity type
     * @return
     */
    public List<A> listActivities();

    /**
     * Selects a single activity
     * @param id
     * @return
     */
    public A getSingleActivity(long id);
}
