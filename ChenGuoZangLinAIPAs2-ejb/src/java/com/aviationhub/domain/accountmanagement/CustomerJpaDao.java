/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.accountmanagement.entity.Customer;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ian
 */
@Dependent
public class CustomerJpaDao implements AccountDao {

    @PersistenceContext(unitName = "ChenGuoZangLinAIPAs2-ejbPU")
    private EntityManager em;

    @Override
    public Account read(String username, String password) {
        //constructs query
        Query query = em.createNamedQuery("findCustomer");
        query.setParameter("username", username);
        query.setParameter("password", password);
        //fetches results
        Customer customer = (Customer) query.getSingleResult();
        //returns resault
        return customer;
    }

    @Override
    public void create(Account account) {
        em.persist(account);
    }

}
