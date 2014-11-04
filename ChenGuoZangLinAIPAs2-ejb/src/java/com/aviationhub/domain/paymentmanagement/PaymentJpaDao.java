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
 * A concrete JPA DAO for payment entities
 * @author ian
 */
@Dependent
public class PaymentJpaDao implements PaymentDao {

    @PersistenceContext(unitName = "ChenGuoZangLinAIPAs2-ejbPU")
    private EntityManager em;

    /**
     *
     * @param payment
     */
    @Override
    public void create(Payment payment) {
        em.persist(payment);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Payment> selectAll() {
        //constructs query
        Query query = em.createNamedQuery("selectAllPayments");
        //fetches results
        List<Payment> payments = query.getResultList();
        return payments;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Payment selectById(Long id) {
        return em.find(Payment.class, id);
    }

    /**
     *
     * @param isSuccess
     * @return
     */
    @Override
    public List<Payment> selectByState(String isSuccess) {
        //constructs query
        Query query = em.createNamedQuery("selectPaymentsByState");
        query.setParameter("success", isSuccess);
        //fetches results
        List<Payment> payments = query.getResultList();
        return payments;
    }
}
