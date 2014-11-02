/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author ian
 */
@Entity
@DiscriminatorValue("JOYFLIGHT")

@NamedQueries({
    @NamedQuery(name = "findAllJoyflights",
            query = "select j from JoyFlight j"),
    @NamedQuery(name = "findOneJoyFlightById",
            query = "select j from JoyFlight j "
            + "where j.id = :id")})

public class JoyFlight extends Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    private int capacity;

    //getters and setters
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
