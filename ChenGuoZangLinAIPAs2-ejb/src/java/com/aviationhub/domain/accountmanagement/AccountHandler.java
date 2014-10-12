/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement;

import com.aviationhub.domain.accountmanagement.entity.Customer;
import java.util.Date;
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
public class AccountHandler {

    @PersistenceContext(unitName = "ChenGuoZangLinAIPAs2-ejbPU")
    private EntityManager em;

    public boolean findAccount(String username, String password) {
        //constructs query
        Query query = em.createNamedQuery("findAccount");
        query.setParameter("username", username);
        query.setParameter("password", password);
        //fetches results
        List<Customer> customers = query.getResultList();
        //returns resault
        return !customers.isEmpty();
    }

    public void createCustomer(String username, String password, String email) {
        //creates new customer
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setEmail(email);
        customer.setDateOfCreation(new Date());
        em.persist(customer);
    }
}
