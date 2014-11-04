/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.administration;

import com.aviationhub.domain.paymentmanagement.PaymentJpaDao;
import com.aviationhub.domain.paymentmanagement.entity.Payment;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * A facade EJB for administration related logics
 * @author ian
 */
@Stateless
public class AdministrationHandler implements AdministrationHandlerLocal {

    @Inject
    PaymentJpaDao paymentDao;
    
    /**
     * Lists all payments
     * @return
     */
    @Override
    public List<Payment> listAllPayments() {
        return paymentDao.selectAll();
    }

    /**
     * Shows detail of a single payment
     * @param id
     * @return
     */
    @Override
    public Payment viewPaymentDetail(Long id) {
        return paymentDao.selectById(id);
    }

    /**
     * Lists payments by given state
     * @param isSuccess
     * @return
     */
    @Override
    public List<Payment> listPaymentsByState(String isSuccess) {
        return paymentDao.selectByState(isSuccess);
    }

}
