/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement;

import java.util.List;

/**
 * A DAO interface for account entities
 * @author ian
 * @param <A>
 */
public interface AccountDao<A> {

    //reads a use by provided username and password
    public List<A> read(String username, String password);

    public void create(A account);
}
