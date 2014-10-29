/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement;

import com.aviationhub.domain.paymentmanagement.transportEntity.CardRequest;
import com.aviationhub.domain.paymentmanagement.transportEntity.ChargeRequest;
import com.aviationhub.domain.paymentmanagement.transportEntity.ChargeResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ian
 */
@Stateless
public class PaymentHandler implements PaymentHandlerLocal {

    private ChargeRequest chargeRequest;
    private ChargeResponse chargeResponse;

    public PaymentHandler() {
        chargeRequest = new ChargeRequest();
        chargeResponse = new ChargeResponse();
    }

    @Override
    public void charge() {

        //dummy request
        CardRequest card = new CardRequest();
        card.setPublishable_api_key("");
        card.setNumber("4200000000000000");
        card.setExpiry_month(12);
        card.setExpiry_year(2016);
        card.setCvc("342");
        card.setName("dummy");
        card.setAddress_line1("dummy");
        card.setAddress_line2("");
        card.setAddress_city("Sydney");
        card.setAddress_postcode("1234");
        card.setAddress_state("NSW");
        card.setAddress_country("Australia");

        chargeRequest.setEmail("dummy@dummy.com");
        chargeRequest.setDescription("dummy goods");
        chargeRequest.setAmount(10);
        chargeRequest.setIp_address("192.168.1.1");
        chargeRequest.setCurrency("AUD");
        chargeRequest.setCapture(true);
        chargeRequest.setCard(card);

        Client client = null;

        try {
            String user = "Qqv4gc6eN65HlT_Bqajqcw";
            String password = "";
            //BasicAuthenticator ba = new BasicAuthenticator(user, password);
            
            client = ClientBuilder.newClient().register(new Authenticator(user, password));
            
            chargeResponse = client.target("https://test-api.pin.net.au/1/charges")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(chargeRequest),ChargeResponse.class);

            System.out.println("response.error: "+ chargeResponse.getError());
            System.out.println("response.error_description: " + chargeResponse.getError_description());
            
            
        } catch (ProcessingException | WebApplicationException e) {
            Logger log = Logger.getLogger(this.getClass().getName());
            log.log(Level.SEVERE, "Could not communicate with payment web service", e);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("An error occurred communicating with the payment server, please try again later"));
            
        } finally {
            if (client != null)
                client.close();
        }
    }

}
