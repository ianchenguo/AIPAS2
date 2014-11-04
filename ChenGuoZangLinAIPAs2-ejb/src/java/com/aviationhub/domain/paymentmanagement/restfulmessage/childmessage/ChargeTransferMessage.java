/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage;

/**
 * A response message object mapping to a sub-level response jason object
 * @author ian
 */
public class ChargeTransferMessage {

    private String state;
    private String paid_at;
    private String token;

    public ChargeTransferMessage() {
    }

    public ChargeTransferMessage(String state, String paid_at, String token) {
        this.state = state;
        this.paid_at = paid_at;
        this.token = token;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(String paid_at) {
        this.paid_at = paid_at;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
