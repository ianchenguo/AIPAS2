/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.bookingmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.bookingmanagement.entity.ShoppingCart;
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
public class ShoppingCartJpaDao implements ShoppingCartDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(ShoppingCart cart) {
        em.persist(cart);
    }

    @Override
    public void update(ShoppingCart cart) {
        em.merge(cart);
    }

    @Override
    public List<ShoppingCart> getByAccount(Account account) {

         //constructs query
         Query query = em.createNamedQuery("getShoppingCartByAccount");
         query.setParameter("account", account);
         //fetches results
         List<ShoppingCart> chart = query.getResultList();
         return chart;
    }

}
