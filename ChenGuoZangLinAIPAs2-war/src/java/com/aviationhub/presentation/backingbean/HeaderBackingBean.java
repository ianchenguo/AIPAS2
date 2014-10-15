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
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

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

    /*public void login() {
     if (accountHandler.findAccount(username, password)) {
     isLoggedIn = true;
     }
     System.out.println("is logged in: "+ isLoggedIn);
     }*/
    
    /**
     * login current user
     *
     * @return @throws NoSuchAlgorithmException
     */
    public String login() throws NoSuchAlgorithmException {
        //create a request local variable to invoke login method
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            //if the current session has a user logged in, log the user out first
            if (hasLoggedIn()) {
                logout();
            }
            //login the account
            request.login(username, password);
            return "welcome";

        } catch (ServletException e) {
            showError("Incorrect username or password");
            return null;
        }
    }

    //a show-error method adapted from week 4 tutorial examples
    private void showError(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }

    /**
     * Test if the current session has logged in
     *
     * @return boolean
     */
    private boolean hasLoggedIn() {
        //System.out.println("KICK IN!");
        HttpServletRequest request = getRequest();
        //System.out.println("get request user: " + request.getRemoteUser());
        return request.getRemoteUser() != null;
    }

    private HttpServletRequest getRequest() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest) context.getExternalContext().getRequest();
    }

    /**
     * log out the user
     *
     * @throws ServletException
     */
    public void logout() throws ServletException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        request.logout();
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
