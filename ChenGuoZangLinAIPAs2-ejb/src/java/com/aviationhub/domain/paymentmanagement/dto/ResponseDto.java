/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement.dto;

import com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage.ErrorMessage;
import java.util.List;

/**
 * A DTO transports response information from an EJB to a backing bean
 * @author ian
 */
public class ResponseDto {

    private String error;
    private String error_description;
    private List<ErrorMessage> messages;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public List<ErrorMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ErrorMessage> messages) {
        this.messages = messages;
    }
}
