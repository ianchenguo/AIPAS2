/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.paymentmanagement.Entity.BookingOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ian
 */
@Stateless
@LocalBean
public class OrderJpaDao implements OrderDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(BookingOrder order) {
        em.persist(order);
    }

    @Override
    public void update(BookingOrder order) {
        em.merge(order);
    }

    @Override
    public void delete(BookingOrder order) {
        em.remove(order);
    }

    @Override
    public List<BookingOrder> selectByAccount(Account account) {
         //constructs query
         Query query = em.createNamedQuery("getOrdersByAccount");
         query.setParameter("account", account);
         //fetches results
         List<BookingOrder> orders = query.getResultList();
         return orders;
    }

}
