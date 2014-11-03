/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.ordermanagement;

import com.aviationhub.domain.ordermanagement.entity.BookingOrderLine;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ian
 */
@Local
public interface ShoppingCartHandlerLocal {

    public void addToShoppingCart(BookingOrderLine orderItem);

    public void removeFromShoppingCart(int itemIndex);

    public void alterItemQuantity(int itemIndex, int quantity);

    public List<BookingOrderLine> listShoppingCartItems();
    
    public void updateShoppingCart(List<BookingOrderLine> orderItems);
}
