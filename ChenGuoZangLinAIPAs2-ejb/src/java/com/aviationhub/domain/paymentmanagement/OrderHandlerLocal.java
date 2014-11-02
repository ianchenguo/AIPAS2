/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import com.aviationhub.domain.paymentmanagement.transportEntity.ChargeResponseDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ian
 */
@Local
public interface OrderHandlerLocal {
    public List<BookingOrder> listOrders(Account account);
    public BookingOrder getOrderById(Long id);
    
    public ChargeResponseDto placeOrder(BookingOrder order);
    
}
