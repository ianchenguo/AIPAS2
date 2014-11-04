/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.ordermanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderStatusEnum;
import java.util.List;

/**
 * A DAO interface for order entities
 * @author ian
 */
public interface BookingOrderDao {

    /**
     * Creates a new order
     * @param order
     */
    public void create(BookingOrder order);

    /**
     * Updates an existing order
     * @param order
     */
    public void update(BookingOrder order);

    /**
     * @deprecated 
     * Deletes an order
     * @param order
     */
    public void delete(BookingOrder order);

    /**
     * @deprecated 
     * Selects orders by given account and status
     * @param account
     * @param status
     * @return
     */
    public List<BookingOrder> selectByAccountAndOrderStatus(Account account, BookingOrderStatusEnum status);

    /**
     * @deprecated 
     * Selects an order by id
     * @param id
     * @return
     */
    public BookingOrder selectById(Long id);
    
    /**
     * @deprecated
     * Selects all orders
     * @return
     */
    public List<BookingOrder> selectAll();

}
