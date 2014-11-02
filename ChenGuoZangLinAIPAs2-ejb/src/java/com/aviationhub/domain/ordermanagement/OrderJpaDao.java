/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.ordermanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderStatusEnum;
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
    public List<BookingOrder> selectByAccountAndOrderStatus(Account account, BookingOrderStatusEnum status) {
        //constructs query
        Query query = em.createNamedQuery("getOrdersByAccountAndStatus");
        query.setParameter("account", account);
        query.setParameter("status", status);
        //fetches results
        List<BookingOrder> orders = query.getResultList();
        return orders;
    }

    @Override
    public BookingOrder selectById(Long id) {
        return em.find(BookingOrder.class, id);
    }

    @Override
    public List<BookingOrder> selectAll() {
        //constructs query
        Query query = em.createNamedQuery("getAllOrders");
        //fetches results
        List<BookingOrder> orders = query.getResultList();
        return orders;
    }

}
