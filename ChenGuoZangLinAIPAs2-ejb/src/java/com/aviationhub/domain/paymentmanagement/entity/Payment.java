/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement.entity;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author ian
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "selectAllPayments",
            query = "select p from Payment p order by p.success, p.created_at"),
    @NamedQuery(name = "selectPaymentsByState",
            query = "select p from Payment p "
                    + "where p.success = :success order by p.created_at")
    })
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Account account;
    @OneToOne
    private BookingOrder bookingOrder;
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
    @ManyToOne(cascade = CascadeType.ALL)
    private PaymentCard card;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PaymentTransfer> transfer;
    private long amount_refunded;
    private long total_fees;
    private long merchant_entitlement;
    private String refund_pending;
    private String authorisation_expired;
    private String captured;
    private String settlement_currency;
    private String charge_token;
    private String error;
    private String errorDescription;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PaymentErrorMessage> errorMessages;

    public Payment() {
    }

    public Payment(Account account, BookingOrder bookingOrder, String token, String success, long amount, String currency, String description, String email, String ip_address, String created_at, String status_message, String error_message, PaymentCard card, List<PaymentTransfer> transfer, long amount_refunded, long total_fees, long merchant_entitlement, String refund_pending, String authorisation_expired, String captured, String settlement_currency, String charge_token, String error, String errorDescription, List<PaymentErrorMessage> errorMessages) {
        this.account = account;
        this.bookingOrder = bookingOrder;
        this.token = token;
        this.success = success;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.email = email;
        this.ip_address = ip_address;
        this.created_at = created_at;
        this.status_message = status_message;
        this.error_message = error_message;
        this.card = card;
        this.transfer = transfer;
        this.amount_refunded = amount_refunded;
        this.total_fees = total_fees;
        this.merchant_entitlement = merchant_entitlement;
        this.refund_pending = refund_pending;
        this.authorisation_expired = authorisation_expired;
        this.captured = captured;
        this.settlement_currency = settlement_currency;
        this.charge_token = charge_token;
        this.error = error;
        this.errorDescription = errorDescription;
        this.errorMessages = errorMessages;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BookingOrder getBookingOrder() {
        return bookingOrder;
    }

    public void setBookingOrder(BookingOrder bookingOrder) {
        this.bookingOrder = bookingOrder;
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

    public PaymentCard getCard() {
        return card;
    }

    public void setCard(PaymentCard card) {
        this.card = card;
    }

    public List<PaymentTransfer> getTransfer() {
        return transfer;
    }

    public void setTransfer(List<PaymentTransfer> transfer) {
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

    public String getCharge_token() {
        return charge_token;
    }

    public void setCharge_token(String charge_token) {
        this.charge_token = charge_token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public List<PaymentErrorMessage> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<PaymentErrorMessage> errorMessages) {
        this.errorMessages = errorMessages;
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
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aviationhub.domain.paymentmanagement.entity.Payment[ id=" + id + " ]";
    }

}
