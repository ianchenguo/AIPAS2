package com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;

/**
 * A response message object mapping to a sub-level response jason object
 * @author ian
 */
public class CardResponseMessage implements Serializable {

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
    private String primary;

    public CardResponseMessage() {
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

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

}
