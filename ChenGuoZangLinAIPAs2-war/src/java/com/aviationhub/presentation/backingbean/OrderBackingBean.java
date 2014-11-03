/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.backingbean;

import com.aviationhub.domain.accountmanagement.AccountHandlerLocal;
import com.aviationhub.domain.accountmanagement.entity.Customer;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderStatusEnum;
import com.aviationhub.domain.paymentmanagement.OrderHandlerLocal;
import com.aviationhub.domain.paymentmanagement.dto.CreditCardDto;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author ian
 */
@Named(value = "orderBackingBean")
@RequestScoped
public class OrderBackingBean implements Serializable{

    @EJB
    OrderHandlerLocal orderHandler;
    
    //test only
    @EJB
    AccountHandlerLocal accountHandler;
    
    @Inject
    ShoppingCartBackingBean shoppingCartBackingBean;
    
    @Inject
    HeaderBackingBean headerBackingBean;
    
    private BookingOrder order = new BookingOrder();
    private CreditCardDto card = new CreditCardDto();
    /**
     * Creates a new instance of OrderBackingBean
     */
    public OrderBackingBean() {
    }
    
    public void checkOut(){
        order.setOrderLines(shoppingCartBackingBean.getCartItems());
        
        //order.setAccount(headerBackingBean.);
        //dummy
        
        order.setAccount((Customer) accountHandler.findCustomer("customer99", "customer99"));
        order.setAddressCity("Sydney");
        order.setAddressCountry("Australia");
        order.setAddressLine1("dummy address line 1");
        order.setAddressLine2("dummy address line 2");
        order.setAddressPostcode("00001");
        order.setAddressState("NSW");
        order.setCellPhoneNo("0000000");
        order.setFirstName("dummyf");
        order.setLandLineNo("0000000");
        order.setLastName("dummyl");
        order.setPlaceTime(new Date());
        order.setTotalPrice(12345);
        order.setOrderStatus(BookingOrderStatusEnum.FINALISED);
        
        card.setCvc("123");
        card.setExpiry_month("12");
        card.setExpiry_year("2016");
        card.setName(order.getFirstName() + " " + order.getLastName());
        card.setNumber("4100000000000001");
       
        orderHandler.placeOrder(order, card);
    }
    
    
    
    

    public BookingOrder getOrder() {
        return order;
    }
    
    
    
    
    
    
}
