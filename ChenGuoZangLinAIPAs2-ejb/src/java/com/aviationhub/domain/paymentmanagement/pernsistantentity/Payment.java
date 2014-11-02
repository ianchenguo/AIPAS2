/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement.pernsistantentity;

import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author ian
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findAllPayments",
            query = "select p from Payment p"),
    })
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private BookingOrder order;
    private String success;
    private String statusMessage;
    private String error;
    private String errorDescription;
    @OneToMany
    private List<PaymentErrorMessage> errorMessages;

    public Payment(BookingOrder order, String success, String statusMessage, String error, String errorDescription, List<PaymentErrorMessage> errorMessages) {
        this.order = order;
        this.success = success;
        this.statusMessage = statusMessage;
        this.error = error;
        this.errorDescription = errorDescription;
        this.errorMessages = errorMessages;
    }

    public Payment() {
        this.errorMessages = new ArrayList<>();
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

    public BookingOrder getOrder() {
        return order;
    }

    public void setOrder(BookingOrder order) {
        this.order = order;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
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
        return "com.aviationhub.domain.paymentmanagement.pernsistantentity.Payment[ id=" + id + " ]";
    }

}
