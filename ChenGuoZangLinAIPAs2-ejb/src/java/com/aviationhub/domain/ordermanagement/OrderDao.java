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
 *
 * @author ian
 */
public interface OrderDao {

    public void create(BookingOrder order);

    public void update(BookingOrder order);

    public void delete(BookingOrder order);

    public List<BookingOrder> selectByAccountAndOrderStatus(Account account, BookingOrderStatusEnum status);

    public BookingOrder selectById(Long id);
    
    public List<BookingOrder> selectAll();

}
