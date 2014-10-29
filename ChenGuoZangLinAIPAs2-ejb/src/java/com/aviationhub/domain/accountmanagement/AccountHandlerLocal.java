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
 *
 * @author ian
 */
@Local
public interface AccountHandlerLocal {
    public Account findCustomer(String username, String password);
    public void createCustomer(Customer customer);
}
