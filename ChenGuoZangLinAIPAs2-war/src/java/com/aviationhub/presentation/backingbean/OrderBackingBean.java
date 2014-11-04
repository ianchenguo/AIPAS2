/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.backingbean;

import com.aviationhub.domain.accountmanagement.AccountHandlerLocal;
import com.aviationhub.domain.accountmanagement.entity.Customer;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderAddress;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderLine;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderStatusEnum;
import com.aviationhub.domain.paymentmanagement.OrderHandlerLocal;
import com.aviationhub.domain.paymentmanagement.dto.CreditCardDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
public class OrderBackingBean implements Serializable {

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
    private BookingOrderAddress address = new BookingOrderAddress();

    /**
     * Creates a new instance of OrderBackingBean
     */
    public OrderBackingBean() {
    }

    public void checkOut() {
        List<BookingOrderLine> lines = new ArrayList<>();

        for (BookingOrderLine line : shoppingCartBackingBean.getCartItems()) {
            lines.add(new BookingOrderLine(line));
        }
        order.setOrderLines(lines);

        //order.setAccount(headerBackingBean.);
        //dummy
        Customer c = (Customer) accountHandler.findCustomer("customer1", "customer1");
        List<Customer> customers = new ArrayList<>();
        customers.add(c);

        address.setAddressCity("Sydney");
        address.setAddressCountry("Australia");
        address.setAddressLine1("dummy address line 1");
        address.setAddressLine2("dummy address line 2");
        address.setAddressPostcode("00001");
        address.setAddressState("NSW");
        address.setAccounts(customers);

        order.setAccount(c);
        order.setAddress(address);
        order.setCellPhoneNo("0000000");
        order.setFirstName("dummyf");
        order.setLandLineNo("0000000");
        order.setLastName("dummyl");
        order.setPlaceTime(new Date());
        order.setTotalPrice(12345);
        order.setIpAddress("");
        order.setIpAddress("192.168.1.1");
        order.setEmail("customer1@dummy.com");

        card.setCvc("123");
        card.setExpiry_month("12");
        card.setExpiry_year("2016");
        card.setName(order.getFirstName() + " " + order.getLastName());
        //successful
        card.setNumber("4200000000000000");

        //declined
        card.setNumber("4100000000000001");
        //Insufficient Funds
        card.setNumber("4000000000000002");
        //Invalid CVV
        card.setNumber("4900000000000003");
        //Invalid Card
        card.setNumber("4800000000000004");
        //Processing Error
        card.setNumber("4700000000000005");
        //Suspected Fraud
        card.setNumber("4600000000000006");

        //Unknown
        card.setNumber("4400000000000099");

        //Invalid Expiry
        //card.setExpiry_year("2012");
        //card.setNumber("4200000000000000");
        //lack of information
        //order.setEmail("");
        orderHandler.placeOrder(order, card);
    }

    public BookingOrder getOrder() {
        return order;
    }

}
