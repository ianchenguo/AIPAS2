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
@DiscriminatorValue("PILOTTRAINING")
@NamedQueries({
    @NamedQuery(name = "findAllPilotTrainings",
            query = "select j from PilotTraining j"),
    @NamedQuery(name = "findSinglePilotTrainingById",
            query = "select j from PilotTraining j "
            + "where j.id = :id")})

public class PilotTraining extends Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String duration;
    private String certificate;

    //getters and setters
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

}
