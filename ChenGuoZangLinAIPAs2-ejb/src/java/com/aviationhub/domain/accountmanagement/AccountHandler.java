/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.accountmanagement.entity.Customer;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ian
 */
@Stateless
public class AccountHandler implements AccountHandlerLocal {

    @EJB
    CustomerJpaDao customerDao;

    @Override
    public Account findCustomer(String username, String password) {
        return customerDao.getAccount(username, password);
    }

    @Override
    public void createCustomer(Customer customer) {
        //creates new customer
        //Customer customer = new Customer();
        //customer.setUsername(username);
        //customer.setPassword(password);
        //customer.setEmail(email);
        //customer.setDateOfCreation(new Date());
        //em.persist(customer);
        customerDao.createAccount(customer);
    }
}
