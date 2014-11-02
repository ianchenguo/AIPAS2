/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement.outertransportentity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author ian
 */
public class ChargeResponse implements Serializable{
    private ChargeCoreResponse coreResponse;
    private String captured;
    private String authorisation_expired;
    private List<String> transfer;
    private int amount_refunded;
    private int total_fees;
    private int merchant_entitlement;
    private String refund_pending;
    private String settlement_currency;
    private String error;
    private String error_description;
    private List<ErrorMessage> messages;
    private String charge_token;

    public ChargeResponse() {
        coreResponse = new ChargeCoreResponse();
        messages = new ArrayList<>();
    }
    
    
    public ChargeCoreResponse getCoreResponse() {
        return coreResponse;
    }

    public void setCoreResponse(ChargeCoreResponse response) {
        this.coreResponse = response;
    }

    public String isCaptured() {
        return captured;
    }

    public void setCaptured(String captured) {
        this.captured = captured;
    }

    public String isAuthorisation_expired() {
        return authorisation_expired;
    }

    public void setAuthorisation_expired(String authorisation_expired) {
        this.authorisation_expired = authorisation_expired;
    }

    public List<String> getTransfer() {
        return transfer;
    }

    public void setTransfer(List<String> transfer) {
        this.transfer = transfer;
    }

    public int getAmount_refunded() {
        return amount_refunded;
    }

    public void setAmount_refunded(int amount_refunded) {
        this.amount_refunded = amount_refunded;
    }

    public int getTotal_fees() {
        return total_fees;
    }

    public void setTotal_fees(int total_fees) {
        this.total_fees = total_fees;
    }

    public int getMerchant_entitlement() {
        return merchant_entitlement;
    }

    public void setMerchant_entitlement(int merchant_entitlement) {
        this.merchant_entitlement = merchant_entitlement;
    }

    public String isRefund_pending() {
        return refund_pending;
    }

    public void setRefund_pending(String refund_pending) {
        this.refund_pending = refund_pending;
    }

    public String getSettlement_currency() {
        return settlement_currency;
    }

    public void setSettlement_currency(String settlement_currency) {
        this.settlement_currency = settlement_currency;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public List<ErrorMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ErrorMessage> messages) {
        this.messages = messages;
    }

    public String getCharge_token() {
        return charge_token;
    }

    public void setCharge_token(String charge_token) {
        this.charge_token = charge_token;
    }
    
}
