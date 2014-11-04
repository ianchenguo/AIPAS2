/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement;

import com.aviationhub.domain.paymentmanagement.entity.Payment;
import java.util.List;

/**
 *
 * @author ian
 */
public interface PaymentDao {

    /**
     * A DAO interface for payment entities
     * @param payment
     */
    public void create(Payment payment);

    /**
     *
     * @return
     */
    public List<Payment> selectAll();

    /**
     *
     * @param id
     * @return
     */
    public Payment selectById(Long id);
    
    /**
     *
     * @param isSuccess
     * @return
     */
    public List<Payment> selectByState(String isSuccess);
}
