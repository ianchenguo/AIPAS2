/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage;

import java.io.Serializable;

/**
 *
 * @author ian
 */
public class ErrorMessage implements Serializable {

    private String code;
    private String message;
    private String param;

    public ErrorMessage() {
    }

    public ErrorMessage(String code, String message, String param) {
        this.code = code;
        this.message = message;
        this.param = param;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

}
