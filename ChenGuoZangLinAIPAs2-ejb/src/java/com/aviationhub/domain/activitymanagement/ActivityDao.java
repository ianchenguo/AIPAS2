/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement;

import java.util.List;

/**
 *
 * @author ian
 * @param <A>
 */
public interface ActivityDao<A> {
    public List<A> listActivities();
    public A getSingleActivity(long id);
}
