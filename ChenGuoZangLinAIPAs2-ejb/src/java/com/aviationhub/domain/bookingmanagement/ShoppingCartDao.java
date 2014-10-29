/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.bookingmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.bookingmanagement.entity.ShoppingCart;
import java.util.List;

/**
 *
 * @author ian
 */
public interface ShoppingCartDao {
    public void create(ShoppingCart cart);
    public List<ShoppingCart> getByAccount(Account account);
    public void update(ShoppingCart cart);
}
