package com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ian
 */
public class ChargeSuccessResponseMessage implements Serializable {

    private String token;
    private boolean success;
    private int amount;
    private String currency;
    private String description;
    private String email;
    private String ip_address;
    private String created_at;
    private String status_message;
    private String error_message;
    private CardResponseMessage card;
    private boolean captured;
    private boolean authorisation_expired;
    private List<ChargeTransferMessage> transfer;
    private int amount_refunded;
    private int total_fees;
    private int merchant_entitlement;
    private boolean refund_pending;
    private String settlement_currency;

    public ChargeSuccessResponseMessage() {
        card = new CardResponseMessage();
        transfer = new ArrayList<>();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public CardResponseMessage getCard() {
        return card;
    }

    public void setCard(CardResponseMessage card) {
        this.card = card;
    }

    public boolean getCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    public boolean isAuthorisation_expired() {
        return authorisation_expired;
    }

    public void setAuthorisation_expired(boolean authorisation_expired) {
        this.authorisation_expired = authorisation_expired;
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

    public boolean isRefund_pending() {
        return refund_pending;
    }

    public void setRefund_pending(boolean refund_pending) {
        this.refund_pending = refund_pending;
    }

    public String getSettlement_currency() {
        return settlement_currency;
    }

    public void setSettlement_currency(String settlement_currency) {
        this.settlement_currency = settlement_currency;
    }

    public List<ChargeTransferMessage> getTransfer() {
        return transfer;
    }

    public void setTransfer(List<ChargeTransferMessage> transfer) {
        this.transfer = transfer;
    }

}
