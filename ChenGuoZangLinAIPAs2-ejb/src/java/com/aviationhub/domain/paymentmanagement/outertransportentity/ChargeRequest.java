/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement.outertransportentity;

import java.io.Serializable;



/**
 *
 * @author ian
 */

public class ChargeRequest implements Serializable{
    private String email;
    private String description;
    private int amount;
    private String ip_address;
    private String currency;
    private String capture = "true";
    private CardRequest card;

    public ChargeRequest() {
        card = new CardRequest();
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public CardRequest getCard() {
        return card;
    }

    public void setCard(CardRequest card) {
        this.card = card;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String isCapture() {
        return capture;
    }

    public void setCapture(String capture) {
        this.capture = capture;
    }
    
    
}
