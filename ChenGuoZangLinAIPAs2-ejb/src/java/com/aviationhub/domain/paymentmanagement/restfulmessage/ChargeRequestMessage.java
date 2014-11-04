/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement.restfulmessage;

import com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage.CardRequestMessage;
import java.io.Serializable;

/**
 * A request message object mapping to a post jason object
 * @author ian
 */
public class ChargeRequestMessage implements Serializable {

    private String email;
    private String description;
    private long amount;
    private String ip_address;
    private String currency;
    private String capture = "true";
    private CardRequestMessage card;

    public ChargeRequestMessage() {
        card = new CardRequestMessage();
    }

    public ChargeRequestMessage(String email, String description, long amount, String ip_address, String currency, CardRequestMessage card) {
        this.email = email;
        this.description = description;
        this.amount = amount;
        this.ip_address = ip_address;
        this.currency = currency;
        this.card = card;
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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public CardRequestMessage getCard() {
        return card;
    }

    public void setCard(CardRequestMessage card) {
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
