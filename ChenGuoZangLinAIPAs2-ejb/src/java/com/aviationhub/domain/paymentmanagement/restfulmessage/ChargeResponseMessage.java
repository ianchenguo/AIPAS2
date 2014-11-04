package com.aviationhub.domain.paymentmanagement.restfulmessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage.ChargeSuccessResponseMessage;
import com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage.ErrorMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ian
 */
public class ChargeResponseMessage implements Serializable {

    private ChargeSuccessResponseMessage response;
    private String error;
    private String error_description;
    private List<ErrorMessage> messages;
    private String charge_token;

    public ChargeResponseMessage() {
        response = new ChargeSuccessResponseMessage();
        messages = new ArrayList<>();
    }

    public ChargeResponseMessage(ChargeSuccessResponseMessage response, String error, String error_description, List<ErrorMessage> messages, String charge_token) {
        this.response = response;
        this.error = error;
        this.error_description = error_description;
        this.messages = messages;
        this.charge_token = charge_token;
    }

    public ChargeSuccessResponseMessage getResponse() {
        return response;
    }

    public void setResponse(ChargeSuccessResponseMessage response) {
        this.response = response;
    }

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

    public String getCharge_token() {
        return charge_token;
    }

    public void setCharge_token(String charge_token) {
        this.charge_token = charge_token;
    }

}
