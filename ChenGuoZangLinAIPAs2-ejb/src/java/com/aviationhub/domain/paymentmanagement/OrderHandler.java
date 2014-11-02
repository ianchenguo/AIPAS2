/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.activitymanagement.ActivityHandler;
import com.aviationhub.domain.activitymanagement.TimeSlotDao;
import com.aviationhub.domain.ordermanagement.OrderDao;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderLine;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderStatusEnum;
import com.aviationhub.domain.paymentmanagement.innertransportentity.CreditCardDto;
import com.aviationhub.domain.paymentmanagement.outertransportentity.CardRequest;
import com.aviationhub.domain.paymentmanagement.outertransportentity.ChargeRequest;
import com.aviationhub.domain.paymentmanagement.outertransportentity.ChargeResponse;
import com.aviationhub.domain.paymentmanagement.innertransportentity.ResponseDto;
import com.aviationhub.domain.paymentmanagement.outertransportentity.ErrorMessage;
import com.aviationhub.domain.paymentmanagement.pernsistantentity.Payment;
import com.aviationhub.domain.paymentmanagement.pernsistantentity.PaymentErrorMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
    @Inject
    PaymentDao paymentDao;
    
    @EJB
    ActivityHandler activityHandler;

    private ChargeResponse charge(BookingOrder order, CreditCardDto creditCardDto) {

        ChargeRequest chargeRequest = createChargeRequest(order, creditCardDto);
        ChargeResponse chargeResponse = null;
        Client client = null;

        try {
            String user = "Qqv4gc6eN65HlT_Bqajqcw";
            String password = "";

            client = ClientBuilder.newClient().register(new Authenticator(user, password));
            //https://test-api.pin.net.au/1/charges
            //http://localhost:8081/1/charges
            chargeResponse = client.target("//http://localhost:8081/1/charges")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(chargeRequest), ChargeResponse.class);

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
        //return responseMessage;
        return chargeResponse;
    }

    private boolean deductTimeSlotQuantity(BookingOrder order) {
        //for each orderline in the order, try to deduct its quantity from the activity time slots
        for (BookingOrderLine l : order.getOrderLines()) {
            boolean isDeducted = activityHandler.deductTimeSlotQuantity(l.getTimeSlotId(), l.getQuantity());
            //if any faliure occurs, return false
            if (!isDeducted) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ResponseDto placeOrder(BookingOrder order, CreditCardDto creditCardDto) {
        //if the time slots are not used up, proceeds check out
        if (deductTimeSlotQuantity(order)) {
            //persists the order
            order.setOrderStatus(BookingOrderStatusEnum.FINALISED);
            orderDao.create(order);
            //charge the order
            ChargeResponse response = charge(order, creditCardDto);
            //persists the charge result
            storePaymentResult(order,response);

            //updates the order's status
            if (response.getCoreResponse().getSuccess().equals("true")) {
                order.setOrderStatus(BookingOrderStatusEnum.PAID);
            } else {
                order.setOrderStatus(BookingOrderStatusEnum.FAILED);
            }
            //creates an inner response dto
            ResponseDto responseDto = createResponseDto(response);

            //returns response message
            return responseDto;
        } else {
            //if any time slot is used up, return null
            return null;
        }
    }

    @Override
    public List<BookingOrder> listOrders(Account account) {
        return orderDao.selectAll();
    }

    @Override
    public BookingOrder getOrderById(Long id) {
        return orderDao.selectById(id);
    }

    @Override
    public List<BookingOrder> listOrdersByAccountAndType(Account account, BookingOrderStatusEnum type) {
        return orderDao.selectByAccountAndOrderStatus(account, type);
    }

    private ChargeRequest createChargeRequest(BookingOrder order, CreditCardDto creditCardDto) {
        ChargeRequest chargeRequest = new ChargeRequest();
        CardRequest card = new CardRequest();

        card.setAddress_city(order.getAddressCity());
        card.setAddress_country(order.getAddressCountry());
        card.setAddress_line1(order.getAddressLine1());
        card.setAddress_line2(order.getAddressLine2());
        card.setAddress_postcode(order.getAddressPostcode());
        card.setAddress_state(order.getAddressState());
        card.setCvc(creditCardDto.getCvc());
        card.setExpiry_month(creditCardDto.getExpiry_month());
        card.setExpiry_year(creditCardDto.getExpiry_year());
        card.setName(creditCardDto.getName());
        card.setNumber(creditCardDto.getNumber());
        card.setPublishable_api_key("");
        chargeRequest.setAmount(order.getTotalPrice());
        chargeRequest.setCapture("true");
        chargeRequest.setCard(card);
        chargeRequest.setCurrency("AUD");
        chargeRequest.setDescription("Aviation Hub booking order");
        chargeRequest.setEmail(order.getAccount().getEmail());
        chargeRequest.setIp_address("");

        //dummy request
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
        chargeRequest.setIp_address("");
        chargeRequest.setCurrency("AUD");
        chargeRequest.setCapture("true");
        chargeRequest.setCard(card);

        return chargeRequest;
    }

    private ResponseDto createResponseDto(ChargeResponse response) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setError(response.getError());
        responseDto.setError_description(response.getError_description());
        responseDto.setMessages(response.getMessages());
        return responseDto;
    }

    private void storePaymentResult(BookingOrder order, ChargeResponse response) {
        
        List<PaymentErrorMessage> messageList = new ArrayList<>();
        for (ErrorMessage em : response.getMessages()) {
            PaymentErrorMessage msg = new PaymentErrorMessage(em.getCode(), em.getMessage(), em.getParam());
            messageList.add(msg);
        }
        Payment payment = new Payment
        (order, response.getCoreResponse().getSuccess(), response.getCoreResponse().getStatus_message(),
                response.getError(), response.getError_description(), messageList);
        
        paymentDao.create(payment);
    }

}
