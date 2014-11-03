/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.backingbean;

import com.aviationhub.domain.accountmanagement.AccountHandlerLocal;
import com.aviationhub.domain.accountmanagement.entity.*;
import com.aviationhub.presentation.backingbean.helper.Encryption;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author ian
 */
@Named
@SessionScoped
public class HeaderBackingBean implements Serializable {
    private String password;
    private String passwordAgain;
    private String username;
    private String email;
    private boolean isLoggedIn;
    private String message;
    private boolean cmp;
    @EJB
    private AccountHandlerLocal accountHandler;
    private Customer customer = new Customer();
   
        
    /**
     * Creates a new instance of HeaderBackingBean
     */
    public HeaderBackingBean() {
        this.isLoggedIn = false;
    }
    
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = getRequest();
        try {
            request.login(username, password);
            if (accountHandler.findCustomer(username, password)!=null) {
                       isLoggedIn = true;
            }
            return "/home?faces-redirect=true";
        }
        catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Invalid username or password"));
            return null;
        }
    }
    
     //Logout method associated with JdbcRealm 
    public String logout() throws ServletException {
        //Conventional way creating HttpServletRequest object
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        request.getSession().invalidate();  
        //Using built-in logout method to logout
        request.logout();
        
        //return to Login page afterwards
        return "home?faces-redirect=true";
    }
    
    public String register() throws NoSuchAlgorithmException { 
        customer.setEmail(email);
        customer.setUsername(username);
        customer.setPassword(Encryption.hash256(password));
        customer.setDateOfCreation(new Date());
        accountHandler.createCustomer(customer);
        return "homeLoggedIn?faces-redirect=true";
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

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public String getMessage() {
        return message;
    }
    
    /*can not return false*/
    public void compare(FacesContext f, UIComponent c){
        if(password.equals(passwordAgain)){
            cmp=true;
        }else{
            cmp=false;
            throw new ValidatorException(new FacesMessage("Password doesn't match"));
        }     
    }
    
    //Unsure why to use this method
    private static HttpServletRequest getRequest() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest)context.getExternalContext().getRequest();
    }
    
     //Creation of showError method
    private void showError(String message) {
        //Create FaceContext object 
        FacesContext context = FacesContext.getCurrentInstance();
        //Add message to FaceContext object
        context.addMessage(null, new FacesMessage(message));
    }
    
}
