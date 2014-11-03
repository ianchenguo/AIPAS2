package com.aviationhub.presentation.backingbean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.aviationhub.domain.activitymanagement.entity.TimeSlot;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderLine;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Zang
 */
@Named
@SessionScoped
public class ShoppingCartBackingBean implements Serializable {

    private List<BookingOrderLine> cartItems;

    @PostConstruct
    private void init() {
        cartItems = new ArrayList<>();
    }

    public void addToCart(TimeSlot ts) {
        BookingOrderLine cartItem = new BookingOrderLine(ts.getActivity(),
                ts.getStartDate(), ts.getEndDate(), ts.getStartTime(), ts.getEndTime(),
                ts.getId(), 1, 1 * ts.getActivity().getPrice());

        BookingOrderLine itemInCart = findItemInCart(cartItem);
        if (itemInCart != null) {
            int currentQuantity = itemInCart.getQuantity();
            itemInCart.setQuantity(cartItem.getQuantity() + currentQuantity);
        } else {
            cartItems.add(cartItem);
        }
    }

    private BookingOrderLine findItemInCart(BookingOrderLine cartItem) {
        boolean isSameActivity;
        boolean isSameTimeSlot;
        for (BookingOrderLine ol : cartItems) {

            isSameActivity = ol.getActivity().getId().equals(cartItem.getActivity().getId());
            isSameTimeSlot = ol.getTimeSlotId().equals(cartItem.getTimeSlotId());

            if (isSameActivity && isSameTimeSlot) {
                return ol;
            }
        }
        return null;
    }
    
    public void deleteItem() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        int ind = Integer.parseInt(params.get("ind"));

        //debug logging info
        //Logger log = Logger.getLogger(this.getClass().getName());
        //log.log(Level.SEVERE, "Text: {0}", params.get("ind"));
        //log.log(Level.SEVERE, "parsedInt: {0}", Integer.parseInt(params.get("ind")));
        //FacesContext context = FacesContext.getCurrentInstance();
        //context.addMessage(null, new FacesMessage(params.get("ind")));

        cartItems.remove(ind);
    }

    public void updateItems() {
        for (BookingOrderLine cartItem : cartItems) {
            if (cartItem.getQuantity() == 0) {
                cartItems.remove(cartItem);
            }
        }
    }

    public List<BookingOrderLine> getCartItems() {
        return cartItems;
    }
}
