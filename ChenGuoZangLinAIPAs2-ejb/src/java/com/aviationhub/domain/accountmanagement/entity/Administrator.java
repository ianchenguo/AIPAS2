/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 * A concrete administrator entity
 * @author ian
 */
@Entity
@DiscriminatorValue("ADMIN")
@NamedQuery(name = "findAdministrator", 
        query="select a from Administrator a where a.username=:username and a.password=:password")
public class Administrator extends Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private String employeeid;

    //getters and setters
    /**
     *
     * @return
     */
        public String getEmployeeid() {
        return employeeid;
    }

    /**
     *
     * @param employeeid
     */
    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }
}
