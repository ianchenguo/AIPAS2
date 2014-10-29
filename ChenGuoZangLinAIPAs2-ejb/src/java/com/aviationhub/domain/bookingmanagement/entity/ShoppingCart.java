/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.bookingmanagement.entity;

import com.aviationhub.domain.accountmanagement.entity.Customer;
import com.aviationhub.domain.activitymanagement.entity.TimeSlot;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author ian
 */


@Entity
@Table (
        uniqueConstraints = @UniqueConstraint(columnNames={"account_id"}))

@NamedQuery(name = "getShoppingCartByAccount", 
        query="select s from ShoppingCart s where s.account = :account")
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    //@OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<TimeSlot> items;
    
    @OneToOne 
    private Customer account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TimeSlot> getItems() {
        return items;
    }

    public void setItems(List<TimeSlot> items) {
        this.items = items;
    }

    public Customer getAccount() {
        return account;
    }

    public void setAccount(Customer account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShoppingCart)) {
            return false;
        }
        ShoppingCart other = (ShoppingCart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aviationhub.domain.bookingmanagement.entity.ShoppingCart[ id=" + id + " ]";
    }

}
