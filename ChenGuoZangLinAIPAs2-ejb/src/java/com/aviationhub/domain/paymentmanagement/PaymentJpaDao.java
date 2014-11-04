/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement;

import com.aviationhub.domain.paymentmanagement.entity.Payment;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ian
 */
@Dependent
public class PaymentJpaDao implements PaymentDao {

    @PersistenceContext(unitName = "ChenGuoZangLinAIPAs2-ejbPU")
    private EntityManager em;

    @Override
    public void create(Payment payment) {
        em.persist(payment);
    }

    @Override
    public List<Payment> selectAll() {
        //constructs query
        Query query = em.createNamedQuery("selectAllPayments");
        //fetches results
        List<Payment> payments = query.getResultList();
        return payments;
    }

    @Override
    public Payment selectById(Long id) {
        return em.find(Payment.class, id);
    }
}
