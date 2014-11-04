/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class does not store sensitive credit card details This class stores
 * An entity storing responded credit card related information
 *
 * @author ian
 */
@Entity
public class PaymentCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;
    private String scheme;
    private String display_number;
    private long expiry_month;
    private long expiry_year;
    private String name;
    private String address_line1;
    private String address_line2;
    private String address_city;
    private String address_postcode;
    private String address_state;
    private String address_country;
    private String isPrimary;

    public PaymentCard() {
    }

    public PaymentCard(String token, String scheme, String display_number, long expiry_month, long expiry_year, String name, String address_line1, String address_line2, String address_city, String address_postcode, String address_state, String address_country, String primaryCard) {
        this.token = token;
        this.scheme = scheme;
        this.display_number = display_number;
        this.expiry_month = expiry_month;
        this.expiry_year = expiry_year;
        this.name = name;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.address_city = address_city;
        this.address_postcode = address_postcode;
        this.address_state = address_state;
        this.address_country = address_country;
        this.isPrimary = primaryCard;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getDisplay_number() {
        return display_number;
    }

    public void setDisplay_number(String display_number) {
        this.display_number = display_number;
    }

    public long getExpiry_month() {
        return expiry_month;
    }

    public void setExpiry_month(long expiry_month) {
        this.expiry_month = expiry_month;
    }

    public long getExpiry_year() {
        return expiry_year;
    }

    public void setExpiry_year(long expiry_year) {
        this.expiry_year = expiry_year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_postcode() {
        return address_postcode;
    }

    public void setAddress_postcode(String address_postcode) {
        this.address_postcode = address_postcode;
    }

    public String getAddress_state() {
        return address_state;
    }

    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }

    public String getAddress_country() {
        return address_country;
    }

    public void setAddress_country(String address_country) {
        this.address_country = address_country;
    }

    public String getPrimaryCard() {
        return isPrimary;
    }

    public void setPrimaryCard(String primaryCard) {
        this.isPrimary = primaryCard;
    }

    public Long getId() {
        return id;
    }

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
        if (!(object instanceof PaymentCard)) {
            return false;
        }
        PaymentCard other = (PaymentCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aviationhub.domain.paymentmanagement.entity.PaymentCard[ id=" + id + " ]";
    }

}
