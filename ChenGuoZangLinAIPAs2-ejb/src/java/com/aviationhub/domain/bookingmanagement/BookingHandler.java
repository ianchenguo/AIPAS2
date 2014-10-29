/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.bookingmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.activitymanagement.entity.TimeSlot;
import com.aviationhub.domain.bookingmanagement.entity.ShoppingCart;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Inject;

/**
 *
 * @author ian
 */
@Stateful
public class BookingHandler implements BookingHandlerLocal,Serializable {

    @Inject
    ShoppingCartDao shoppingCartDao;
    
    @Override
    public void createShoppingCart(ShoppingCart cart) {
        shoppingCartDao.create(cart);
    }


    @Override
    public ShoppingCart getShoppingChartByAccount(Account account) {
        List<ShoppingCart> result = shoppingCartDao.getByAccount(account);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void addToShoppingCart(TimeSlot ativitySession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeFromShoppingCart(TimeSlot activitySession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterItemQuantity(TimeSlot activitySession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
