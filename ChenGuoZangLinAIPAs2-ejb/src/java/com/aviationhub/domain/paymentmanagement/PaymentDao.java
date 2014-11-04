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

    public void create(Payment payment);

    public List<Payment> selectAll();

    public Payment selectById(Long id);
    
    public List<Payment> selectByState(String isSuccess);
}
