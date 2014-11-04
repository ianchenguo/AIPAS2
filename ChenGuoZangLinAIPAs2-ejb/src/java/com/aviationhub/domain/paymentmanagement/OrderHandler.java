/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement;

import com.aviationhub.domain.accountmanagement.entity.Account;
import com.aviationhub.domain.activitymanagement.TimeSlotDao;
import com.aviationhub.domain.ordermanagement.OrderDao;
import com.aviationhub.domain.ordermanagement.entity.BookingOrder;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderAddress;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderStatusEnum;
import com.aviationhub.domain.paymentmanagement.dto.CreditCardDto;
import com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage.CardRequestMessage;
import com.aviationhub.domain.paymentmanagement.restfulmessage.ChargeRequestMessage;
import com.aviationhub.domain.paymentmanagement.restfulmessage.ChargeResponseMessage;
import com.aviationhub.domain.paymentmanagement.dto.ResponseDto;
import com.aviationhub.domain.paymentmanagement.entity.Payment;
import com.aviationhub.domain.paymentmanagement.entity.PaymentCard;
import com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage.ErrorMessage;
import com.aviationhub.domain.paymentmanagement.entity.PaymentErrorMessage;
import com.aviationhub.domain.paymentmanagement.entity.PaymentTransfer;
import com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage.CardResponseMessage;
import com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage.ChargeSuccessResponseMessage;
import com.aviationhub.domain.paymentmanagement.restfulmessage.childmessage.ChargeTransferMessage;
import java.util.ArrayList;
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
import javax.ws.rs.core.Response;

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

    private ChargeResponseMessage charge(BookingOrder order, CreditCardDto creditCardDto) {

        //instantiates and populates a reqeust object
        ChargeRequestMessage chargeRequest = createChargeRequest(order, creditCardDto);
        //instantiates an empty response object
        ChargeResponseMessage chargeResponse = null;
        //declares a jax rs client
        Client client = null;

        try {
            //declares user and password for basic http authentication
            String user = "Qqv4gc6eN65HlT_Bqajqcw";
            String password = "";
            //instantiates the jax rs client with a basic http authenticator
            client = ClientBuilder.newClient().register(new Authenticator(user, password));
            //conducts a restful request
            //formal url: https://test-api.pin.net.au/1/charges
            //local testing url: http://localhost:8081/1/charges
            Response response = client.target("http://localhost:8081/1/charges")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(chargeRequest));
            //converts the response message to a response object
            chargeResponse = response.readEntity(ChargeResponseMessage.class);
            //chargeResponse = response.readEntity(TestResponseMessage.class);

        } catch (ProcessingException | WebApplicationException e) {

            Logger log = Logger.getLogger(this.getClass().getName());
            log.log(Level.SEVERE, "Could not communicate with payment web service {0}", e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("An error occurred communicating with the payment server, please try again later"));

        } finally {
            //releases the client
            if (client != null) {
                client.close();
            }
        }
        return chargeResponse;
    }

    @Override
    public ResponseDto placeOrder(BookingOrder order, CreditCardDto creditCardDto) {

        //persists the order
        order.setOrderStatus(BookingOrderStatusEnum.FINALISED);
        orderDao.create(order);

        //charge the order
        ChargeResponseMessage response = charge(order, creditCardDto);
        //TestResponseMessage response = charge(order, creditCardDto);

        //debug logging info
        Logger log = Logger.getLogger(this.getClass().getName());
        log.log(Level.SEVERE, "error: {0}", response.getError());
        //log.log(Level.SEVERE, "isSuccess: {0}", response.getResponse().getSuccess());
        //log.log(Level.SEVERE, "ammount: {0}", response.getResponse().getAmount());
        //log.log(Level.SEVERE, "primary: {0}", responseCard.getPrimary());
        //FacesContext context = FacesContext.getCurrentInstance();
        //String test = "false";
        //if (response.getResponse().getSuccess().equals("true")) {
        //    test = "true";
        //}
        //context.addMessage(null, new FacesMessage(test));
        //context.addMessage(null, new FacesMessage(response.getError()));

        //persists the charge result
        storePaymentResult(order, response);

        //updates the order's status
        if (response.getResponse().getSuccess().equals("true")) {
            order.setOrderStatus(BookingOrderStatusEnum.PAID);
        } else {
            order.setOrderStatus(BookingOrderStatusEnum.FAILED);
        }
        orderDao.update(order);
        //creates an inner response dto
        ResponseDto responseDto = createResponseDto(response);

        //returns response message
        return responseDto; 
    }

    private ChargeRequestMessage createChargeRequest(BookingOrder order, CreditCardDto cardDto) {

        BookingOrderAddress oa = order.getAddress();
        CardRequestMessage card
                = new CardRequestMessage("", cardDto.getNumber(), cardDto.getExpiry_month(),
                        cardDto.getExpiry_year(), cardDto.getCvc(), cardDto.getName(), oa.getAddressLine1(),
                        oa.getAddressLine2(), oa.getAddressCity(),
                        oa.getAddressPostcode(), oa.getAddressState(), oa.getAddressCountry());

        ChargeRequestMessage chargeRequest
                = new ChargeRequestMessage(order.getEmail(), "Aviation Hub booking order", order.getTotalPrice(), order.getIpAddress(), "AUD", card);

        /*
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
         */
        return chargeRequest;
    }

    private ResponseDto createResponseDto(ChargeResponseMessage response) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setError(response.getError());
        responseDto.setError_description(response.getError_description());
        responseDto.setMessages(response.getMessages());
        return responseDto;
    }

    private void storePaymentResult(BookingOrder order, ChargeResponseMessage response) {

        CardResponseMessage rc = response.getResponse().getCard();
        PaymentCard card
                = new PaymentCard(rc.getToken(), rc.getScheme(),
                        rc.getDisplay_number(), rc.getExpiry_month(),
                        rc.getExpiry_year(), rc.getName(),
                        rc.getAddress_line1(), rc.getAddress_line2(),
                        rc.getAddress_city(), rc.getAddress_postcode(),
                        rc.getAddress_state(), rc.getAddress_country(), rc.getPrimary());

        List<PaymentErrorMessage> messageList = new ArrayList<>();
        for (ErrorMessage em : response.getMessages()) {
            PaymentErrorMessage msg = new PaymentErrorMessage(em.getCode(), em.getMessage(), em.getParam());
            messageList.add(msg);
        }
        
        ChargeSuccessResponseMessage csr = response.getResponse();
        List<PaymentTransfer> paymentTransfers = new ArrayList<>();
        for (ChargeTransferMessage ct : csr.getTransfer()) {
            PaymentTransfer pt = new PaymentTransfer(ct.getState(), ct.getPaid_at(), ct.getToken());
            paymentTransfers.add(pt);
        }

        Payment payment = 
                new Payment(order.getAccount(), order, csr.getToken(), csr.getSuccess(), csr.getAmount(), 
                        csr.getCurrency(), csr.getDescription(), csr.getEmail(), csr.getIp_address(), csr.getCreated_at(), 
                        csr.getStatus_message(), csr.getError_message(), card, paymentTransfers, csr.getAmount_refunded(), 
                        csr.getTotal_fees(), csr.getMerchant_entitlement(), csr.getRefund_pending(), 
                        csr.getAuthorisation_expired(), csr.getCaptured(), csr.getSettlement_currency(), 
                        response.getCharge_token(), response.getError(), response.getError_description(), messageList);

        paymentDao.create(payment);
    }

    @Override
    public BookingOrder getOrderById(Long id) {
        return orderDao.selectById(id);
    }

    @Override
    public List<BookingOrder> listOrdersByAccountAndType(Account account, BookingOrderStatusEnum type) {
        return orderDao.selectByAccountAndOrderStatus(account, type);
    }

    @Override
    public List<BookingOrder> listOrders(Account account) {
        return orderDao.selectAll();
    }
}
