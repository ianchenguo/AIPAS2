/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.ordermanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderLine;
import javax.ejb.Local;

/**
 *
 * @author ian
 */
@Local
public interface ShoppingCartHandlerLocal {
    
    public BookingOrder getPendingOrder();
    //public BookingOrder getPendingOrder(Account account);

    public void addToShoppingCart(BookingOrderLine orderItem);

    public void removeFromShoppingCart(BookingOrderLine orderItem);

    public void alterItemQuantity(int itemIndex, int quantity);
    //public void commitToOrder();
}
