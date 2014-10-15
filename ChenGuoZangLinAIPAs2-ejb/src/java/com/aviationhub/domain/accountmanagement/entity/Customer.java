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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author ian
 */
@Entity
@DiscriminatorValue("CUSTOMER")
@NamedQuery(name = "findAccount", 
        query="select c from Customer c where c.username=:username and c.password=:password")

public class Customer extends Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}∼-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}∼-]+)*"
            + "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Email format is invalid.")
    @Size(max = 255)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
