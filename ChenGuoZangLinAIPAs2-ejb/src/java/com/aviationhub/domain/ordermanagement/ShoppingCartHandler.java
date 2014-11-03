/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.ordermanagement;

import com.aviationhub.domain.ordermanagement.entity.BookingOrderLine;
import com.aviationhub.domain.paymentmanagement.OrderHandlerLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.inject.Inject;

/**
 *
 * @author ian
 */
@Stateful
public class ShoppingCartHandler implements ShoppingCartHandlerLocal, Serializable {

    @Inject
    OrderDao orderDao;
    
    @EJB
    OrderHandlerLocal orderHandler;
    
    private List<BookingOrderLine> orderLines;

    @PostConstruct
    private void init() {
        orderLines = new ArrayList<>();
    }

    @Override
    public void addToShoppingCart(BookingOrderLine orderItem) {

        BookingOrderLine itemInCart = findItemInCart(orderItem);
        if (itemInCart != null) {
            int currentQuantity = itemInCart.getQuantity();
            itemInCart.setQuantity(orderItem.getQuantity() + currentQuantity);
        } else {
            orderLines.add(orderItem);
        }

        
    }

    @Override
    public void removeFromShoppingCart(int itemIndex) {
        orderLines.remove(itemIndex);
    }

    private BookingOrderLine findItemInCart(BookingOrderLine orderItem) {
        boolean isSameActivity;
        boolean isSameTimeSlot;
        for (BookingOrderLine ol : orderLines) {

            isSameActivity = ol.getActivity().getId().equals(orderItem.getActivity().getId());
            isSameTimeSlot = ol.getTimeSlotId().equals(orderItem.getTimeSlotId());

            if (isSameActivity && isSameTimeSlot) {
                return ol;
            }
        }
        return null;
    }

    /*
     @Override
     public BookingOrder getPendingOrder(Account account) {
     //calls the dao to retrieve a list of pending orders, containing zero or one element
     List<BookingOrder> orders = orderDao.selectByAccountAndOrderStatus(account, BookingOrderStatusEnum.PENDING);
     //if the list is empty, create a pending order for the account
     if (orders.isEmpty()) {
     BookingOrder order = new BookingOrder();
     order.setAccount(account);
     order.setOrderStatus(BookingOrderStatusEnum.PENDING);
     return order;
     } else {
     //else return the first element in the result list
     return orders.get(0);
     }
     }*/
    @Override
    public void alterItemQuantity(int itemIndex, int quantity) {
        BookingOrderLine orderline = orderLines.get(itemIndex);
        orderline.setQuantity(quantity);
    }

    // @Override
    //public void commitToOrder() {
    //    pendingOrder.setOrderStatus(BookingOrderStatusEnum.COMMITED);
    //    orderDao.create(pendingOrder);
    //}
    //getters and setters
    //@Override
    //public BookingOrder getPendingOrder() {
    //    return pendingOrder;
    //}

    //@Override
    //public ResponseDto checkout(CreditCardDto creditCardDto) {
    //    return orderHandler.placeOrder(pendingOrder, creditCardDto);
    //}

    @Override
    public List<BookingOrderLine> listShoppingCartItems() {
        return orderLines;
    }

    @Override
    public void updateShoppingCart(List<BookingOrderLine> orderItems) {
    }

}
