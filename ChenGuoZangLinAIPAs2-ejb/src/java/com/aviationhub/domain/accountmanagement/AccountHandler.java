/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.accountmanagement.entity.Customer;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ian
 */
@Stateless
public class AccountHandler implements AccountHandlerLocal {

    @Inject
    CustomerJpaDao customerDao;

    @Override
    public Account findCustomer(String username, String password) {
        return customerDao.read(username, password);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerDao.create(customer);
    }
}
