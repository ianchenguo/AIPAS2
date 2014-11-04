/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.ordermanagement.entity;

import com.aviationhub.domain.accountmanagement.entity.Customer;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author ian
 */
@Entity
public class BookingOrderAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    private List<Customer> accounts;
    private String addressLine1;
    private String addressLine2;
    private String addressCity;
    private String addressState;
    private String addressPostcode;
    private String addressCountry;

    /**
     *
     */
    public BookingOrderAddress() {
    }

    /**
     *
     * @param accounts
     * @param addressLine1
     * @param addressLine2
     * @param addressCity
     * @param addressState
     * @param addressPostcode
     * @param addressCountry
     */
    public BookingOrderAddress(List<Customer> accounts, String addressLine1, String addressLine2, String addressCity, String addressState, String addressPostcode, String addressCountry) {
        this.accounts = accounts;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.addressPostcode = addressPostcode;
        this.addressCountry = addressCountry;
    }

    /**
     *
     * @return
     */
    public List<Customer> getAccounts() {
        return accounts;
    }

    /**
     *
     * @param accounts
     */
    public void setAccounts(List<Customer> accounts) {
        this.accounts = accounts;
    }

    /**
     *
     * @return
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     *
     * @param addressLine1
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     *
     * @return
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     *
     * @param addressLine2
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     *
     * @return
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     *
     * @param addressCity
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    /**
     *
     * @return
     */
    public String getAddressState() {
        return addressState;
    }

    /**
     *
     * @param addressState
     */
    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    /**
     *
     * @return
     */
    public String getAddressPostcode() {
        return addressPostcode;
    }

    /**
     *
     * @param addressPostcode
     */
    public void setAddressPostcode(String addressPostcode) {
        this.addressPostcode = addressPostcode;
    }

    /**
     *
     * @return
     */
    public String getAddressCountry() {
        return addressCountry;
    }

    /**
     *
     * @param addressCountry
     */
    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof BookingOrderAddress)) {
            return false;
        }
        BookingOrderAddress other = (BookingOrderAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aviationhub.domain.ordermanagement.entity.BookingOrderAddress[ id=" + id + " ]";
    }

}
