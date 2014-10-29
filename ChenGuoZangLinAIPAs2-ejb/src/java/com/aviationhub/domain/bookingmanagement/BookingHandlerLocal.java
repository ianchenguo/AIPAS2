/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.bookingmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.activitymanagement.entity.TimeSlot;
import com.aviationhub.domain.bookingmanagement.entity.ShoppingCart;
import javax.ejb.Local;

/**
 *
 * @author ian
 */
@Local
public interface BookingHandlerLocal {
    public void createShoppingCart(ShoppingCart cart);
    //public void modifyShoppingCart(ShoppingCart cart);
    public ShoppingCart getShoppingChartByAccount(Account account);
    
    public void addToShoppingCart(TimeSlot ativitySession);
    public void removeFromShoppingCart(TimeSlot activitySession);
    public void alterItemQuantity(TimeSlot activitySession);

}
