/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;

/**
 *
 * @author ian
 */
public interface AccountDao {
    public Account read(String username, String password);
    public void create(Account account);
}
