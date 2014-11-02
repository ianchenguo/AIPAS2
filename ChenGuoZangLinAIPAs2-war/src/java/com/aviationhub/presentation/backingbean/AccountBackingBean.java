/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.backingbean;

import com.aviationhub.domain.accountmanagement.AccountHandlerLocal;
import com.aviationhub.domain.accountmanagement.entity.Customer;
import com.aviationhub.domain.ordermanagement.ShoppingCartHandlerLocal;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderLine;
import com.aviationhub.domain.paymentmanagement.OrderHandlerLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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
    private boolean isLoggedIn = false;
    private BookingOrder pendingOrder = new BookingOrder();

    @EJB
    AccountHandlerLocal ah;
    @EJB
    ShoppingCartHandlerLocal sh;
    @EJB
    OrderHandlerLocal ph;

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

    /*
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
     }*/
    public List<BookingOrderLine> viewShoppingItems() {
        getPendingOrder();
        return pendingOrder.getOrderLines();
    }

    private void getPendingOrder() {
        this.pendingOrder = sh.getPendingOrder();
    }
    
    public void addDummyItem(){
        //creates a dummy item
        BookingOrderLine cartItem1 = new BookingOrderLine();
        cartItem1.setStartDate(new Date());
        cartItem1.setQuantity(1);
        sh.addToShoppingCart(cartItem1);
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

}
