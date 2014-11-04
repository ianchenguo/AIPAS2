/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.administration;

import com.aviationhub.domain.paymentmanagement.entity.Payment;
import java.util.List;
import javax.ejb.Local;

/**
 * A local interface for the facade EJB of administration related logics
 * @author ian
 */
@Local
public interface AdministrationHandlerLocal {

    /**
     * Lists all payments
     * @return
     */
    public List<Payment> listAllPayments();
    
    /**
     * Shows detail of a single payment
     * @param isSuccess
     * @return
     */
    public List<Payment> listPaymentsByState(String isSuccess);

    /**
     * Lists payments by given state
     * @param id
     * @return
     */
    public Payment viewPaymentDetail(Long id);
    
}
