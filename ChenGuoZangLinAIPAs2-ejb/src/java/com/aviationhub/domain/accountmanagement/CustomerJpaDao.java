/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement;

import com.aviationhub.domain.accountmanagement.entity.Customer;
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
public class CustomerJpaDao implements AccountDao<Customer> {

    @PersistenceContext(unitName = "ChenGuoZangLinAIPAs2-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Customer> read(String username, String password) {
        //constructs query
        Query query = em.createNamedQuery("findCustomer");
        query.setParameter("username", username);
        query.setParameter("password", password);
        //fetches results
        List<Customer> customers = query.getResultList();
        //returns resault
        return customers;
    }

    @Override
    public void create(Customer account) {
        em.persist(account);
    }

}
