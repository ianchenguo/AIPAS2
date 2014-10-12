/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.backingbean;

import com.aviationhub.domain.accountmanagement.AccountHandler;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author ian
 */
@Named(value = "headerBackingBean")
@SessionScoped
public class HeaderBackingBean implements Serializable {


    
    private String password;
    private String username;
    private String email;
    private boolean isLoggedIn;
    @EJB
    private AccountHandler accountHandler;
        
    /**
     * Creates a new instance of HeaderBackingBean
     */
    public HeaderBackingBean() {
        this.isLoggedIn = false;
    }
    
    public void login() {
        if (accountHandler.findAccount(username, password)) {
            isLoggedIn = true;
        }
        System.out.println("is logged in: "+ isLoggedIn);
    }
    
    public void register() {
        accountHandler.createCustomer(username, password, email);
    }

    //getters and setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    
}
