/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ian
 */
@Entity
@DiscriminatorValue("ADMIN")
public class Administrator extends Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private String employeeid;

    //getters and setters
    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }
}
