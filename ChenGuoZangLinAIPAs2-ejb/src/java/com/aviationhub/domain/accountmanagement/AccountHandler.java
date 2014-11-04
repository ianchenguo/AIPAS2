/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.accountmanagement.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * A facade EJB for account related logics
 * @author ian
 */
@Stateless
public class AccountHandler implements AccountHandlerLocal {

    @Inject
    CustomerJpaDao customerDao;

    /**
     * Finds a customer by provided username and password
     * @param username
     * @param password
     * @return
     */
    @Override
    public Account findCustomer(String username, String password) {
        
        List<Customer> customers = customerDao.read(username, password);
        
        if (customers.isEmpty()) {
            return null;
        } else {
            return customers.get(0);
        }
    }

    /**
     * Creates a new customer
     * @param customer
     */
    @Override
    public void createCustomer(Customer customer) {
        customerDao.create(customer);
    }
}
