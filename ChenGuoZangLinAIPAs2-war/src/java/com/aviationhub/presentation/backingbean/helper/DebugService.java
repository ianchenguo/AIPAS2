/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.backingbean.helper;

import com.aviationhub.domain.paymentmanagement.restfulmessage.ChargeRequestMessage;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author ian
 */
@Path("debug")
public class DebugService {

    @EJB
    private ChargeRequestMessage chargeRequest;

    @GET
    //public Message peek() {
    //    return swapBean.peek();
    //}

    @POST
    public void charge(ChargeRequestMessage message) {
        
    }
}
