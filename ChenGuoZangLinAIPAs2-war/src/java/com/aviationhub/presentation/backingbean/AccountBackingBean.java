/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.backingbean;

import com.aviationhub.domain.accountmanagement.AccountHandlerLocal;
import com.aviationhub.domain.accountmanagement.entity.Customer;
import com.aviationhub.domain.bookingmanagement.BookingHandlerLocal;
import com.aviationhub.domain.bookingmanagement.entity.ShoppingCart;
import com.aviationhub.domain.paymentmanagement.PaymentHandler;
import com.aviationhub.domain.paymentmanagement.PaymentHandlerLocal;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ian
 */
@Named(value = "accountBackingBean")
@SessionScoped
public class AccountBackingBean implements Serializable {

    private Customer customer = new Customer();
    private ShoppingCart cart = new ShoppingCart();
    private boolean isLoggedIn = false;

    @EJB
    AccountHandlerLocal ah;
    @EJB
    BookingHandlerLocal bh;
    @EJB
    PaymentHandlerLocal ph;

    /**
     * Creates a new instance of AccountBackingBean
     */
    public AccountBackingBean() {
    }

    public void createCustomer() {

        Customer newCustomer = new Customer();
        newCustomer.setEmail(this.customer.getEmail());
        newCustomer.setUsername(this.customer.getUsername());
        newCustomer.setPassword(this.customer.getPassword());
        newCustomer.setDateOfCreation(new Date());

        ah.createCustomer(newCustomer);
    }

    public void findCustomer() {

        this.customer
                = (Customer) ah.findCustomer(this.customer.getUsername(), this.customer.getPassword());
    }

    public void loginCustomer() {

        this.customer
                = (Customer) ah.findCustomer(this.customer.getUsername(), this.customer.getPassword());
        this.isLoggedIn = true;
    }

    public void createShoppingCart() {
        if (bh.getShoppingChartByAccount(customer) == null) {
            ShoppingCart newShoppingCart = new ShoppingCart();
            newShoppingCart.setAccount(customer);
            bh.createShoppingCart(newShoppingCart);
        }
        cart = bh.getShoppingChartByAccount(customer);
    }

    public void charge() {
        ph.charge();
    }
    
    
    //getters and setters
    public Customer getCustomer() {
        return customer;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public ShoppingCart getCart() {
        return cart;
    }

}
