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
    private String success;
    private long amount;
    private String currency;
    private String description;
    private String email;
    private String ip_address;
    private String created_at;
    private String status_message;
    private String error_message;
    private CardResponseMessage card;
    private List<ChargeTransferMessage> transfer;
    private long amount_refunded;
    private long total_fees;
    private long merchant_entitlement;
    private String refund_pending;
    private String authorisation_expired;
    private String captured;
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

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
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

    public List<ChargeTransferMessage> getTransfer() {
        return transfer;
    }

    public void setTransfer(List<ChargeTransferMessage> transfer) {
        this.transfer = transfer;
    }

    public long getAmount_refunded() {
        return amount_refunded;
    }

    public void setAmount_refunded(long amount_refunded) {
        this.amount_refunded = amount_refunded;
    }

    public long getTotal_fees() {
        return total_fees;
    }

    public void setTotal_fees(long total_fees) {
        this.total_fees = total_fees;
    }

    public long getMerchant_entitlement() {
        return merchant_entitlement;
    }

    public void setMerchant_entitlement(long merchant_entitlement) {
        this.merchant_entitlement = merchant_entitlement;
    }

    public String getRefund_pending() {
        return refund_pending;
    }

    public void setRefund_pending(String refund_pending) {
        this.refund_pending = refund_pending;
    }

    public String getAuthorisation_expired() {
        return authorisation_expired;
    }

    public void setAuthorisation_expired(String authorisation_expired) {
        this.authorisation_expired = authorisation_expired;
    }

    public String getCaptured() {
        return captured;
    }

    public void setCaptured(String captured) {
        this.captured = captured;
    }

    public String getSettlement_currency() {
        return settlement_currency;
    }

    public void setSettlement_currency(String settlement_currency) {
        this.settlement_currency = settlement_currency;
    }

}
