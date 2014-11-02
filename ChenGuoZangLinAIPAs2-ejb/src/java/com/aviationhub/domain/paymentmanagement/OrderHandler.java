/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.activitymanagement.TimeSlotDao;
import com.aviationhub.domain.activitymanagement.entity.TimeSlot;
import com.aviationhub.domain.ordermanagement.OrderDao;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderLine;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderStatusEnum;
import com.aviationhub.domain.paymentmanagement.transportEntity.CardRequest;
import com.aviationhub.domain.paymentmanagement.transportEntity.ChargeRequest;
import com.aviationhub.domain.paymentmanagement.transportEntity.ChargeResponse;
import com.aviationhub.domain.paymentmanagement.transportEntity.ChargeResponseDto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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
public class OrderHandler implements OrderHandlerLocal {

    @Inject
    OrderDao orderDao;
    @Inject
    TimeSlotDao timeSlotDao;

    private ChargeRequest chargeRequest;
    private ChargeResponse chargeResponse;

    private ChargeResponseDto charge(BookingOrder order) {

        //dummy request
        CardRequest card = new CardRequest();
        card.setPublishable_api_key("");
        card.setNumber("4200000000000000");
        card.setExpiry_month("12");
        card.setExpiry_year("2016");
        card.setCvc("342");
        card.setName("dummy dummy");
        card.setAddress_line1("dummy");
        card.setAddress_line2("");
        card.setAddress_city("Sydney");
        card.setAddress_postcode("1234");
        card.setAddress_state("NSW");
        card.setAddress_country("Australia");

        chargeRequest.setEmail("dummy@dummy.com");
        chargeRequest.setDescription("dummy goods");
        chargeRequest.setAmount(110);
        chargeRequest.setIp_address("10.0.0.123");
        chargeRequest.setCurrency("AUD");
        chargeRequest.setCapture("true");
        chargeRequest.setCard(card);

        Client client = null;
        ChargeResponseDto responseMessage = new ChargeResponseDto();
        try {
            String user = "Qqv4gc6eN65HlT_Bqajqcw";
            String password = "";

            client = ClientBuilder.newClient().register(new Authenticator(user, password));
            //https://test-api.pin.net.au/1/charges
            //http://localhost:8081/1/charges
            chargeResponse = client.target("https://test-api.pin.net.au/1/charges")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(chargeRequest), ChargeResponse.class);

            responseMessage.setError(chargeResponse.getError());
            responseMessage.setError_description(chargeResponse.getError_description());
            responseMessage.setMessages(chargeResponse.getMessages());

            System.out.println("testtesttest");
            System.out.println("response.error: " + chargeResponse.getError());
            System.out.println("response.error_description: " + chargeResponse.getError_description());

        } catch (ProcessingException | WebApplicationException e) {
            Logger log = Logger.getLogger(this.getClass().getName());
            log.log(Level.SEVERE, "Could not communicate with payment web service", e);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("An error occurred communicating with the payment server, please try again later"));

        } finally {
            if (client != null) {
                client.close();
            }
        }

        return responseMessage;
    }

    @Override
    public List<BookingOrder> listOrders(Account account) {
        return orderDao.selectAll();
    }

    @Override
    public BookingOrder getOrderById(Long id) {
        return orderDao.selectById(id);
    }

    private boolean deductTimeSlotQuantity(BookingOrder order) {
        for (BookingOrderLine l : order.getOrderLines()) {
            TimeSlot ts = timeSlotDao.selectById(l.getTimeSlotId());
            int quantity = ts.getQuantity() - l.getQuantity();
            if (quantity >= 0) {
                ts.setQuantity(quantity);
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public ChargeResponseDto placeOrder(BookingOrder order) {

        if (deductTimeSlotQuantity(order)) {
            ChargeResponseDto responseMessage = charge(order);
            if (chargeResponse.getError().equals("")) {
                orderDao.create(order);
            }
            return responseMessage;
        } else {
            return null;
        }
    }

}
