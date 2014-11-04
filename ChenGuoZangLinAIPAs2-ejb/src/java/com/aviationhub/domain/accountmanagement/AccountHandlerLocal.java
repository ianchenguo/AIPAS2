/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.accountmanagement.entity.Customer;
import javax.ejb.Local;

/**
 * A local interface for the facade EJB of account related logics
 * @author ian
 */
@Local
public interface AccountHandlerLocal {

    /**
     * Finds a customer by provided username and password
     * @param username
     * @param password
     * @return
     */
    public Account findCustomer(String username, String password);

    /**
     * Creates a new customer
     * @param customer
     */
    public void createCustomer(Customer customer);
}
