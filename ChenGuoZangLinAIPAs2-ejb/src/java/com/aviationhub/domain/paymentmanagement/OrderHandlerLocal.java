/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderStatusEnum;
import com.aviationhub.domain.paymentmanagement.dto.CreditCardDto;
import com.aviationhub.domain.paymentmanagement.dto.ResponseDto;
import java.util.List;
import javax.ejb.Local;

/**
 * A local interface for the facade EJB of order related logics
 * @author ian
 */
@Local
public interface OrderHandlerLocal {

    /**
     * @deprecated 
     * Lists all orders of an account
     * @param account
     * @return
     */
    public List<BookingOrder> listOrders(Account account);
    
    /**
     * @deprecated 
     * Lists all orders by given account and order type
     * @param account
     * @param type
     * @return
     */
    public List<BookingOrder> listOrdersByAccountAndType(Account account, BookingOrderStatusEnum type);
    
    /**
     * @deprecated 
     * Gets an order by given id
     * @param id
     * @return
     */
    public BookingOrder getOrderById(Long id);
    
    /**
     * Places an order
     * @param order
     * @param creditCardDto
     * @return
     */
    public ResponseDto placeOrder(BookingOrder order, CreditCardDto creditCardDto);
    
}
