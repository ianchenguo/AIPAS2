/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.aviationhub.domain.activitymanagement.ActivityHandlerLocal;
import com.aviationhub.domain.activitymanagement.entity.PilotTraining;
import com.aviationhub.domain.activitymanagement.entity.TimeSlot;
import com.aviationhub.domain.ordermanagement.ShoppingCartHandlerLocal;
import com.aviationhub.domain.ordermanagement.entity.BookingOrderLine;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Zang
 */
@Named
@SessionScoped
public class ShoppingCartBackingBean implements Serializable {

    @EJB
    private ShoppingCartHandlerLocal shoppingcarthandler;
    private List<BookingOrderLine> orderline = new ArrayList<>();


    public String addToCart(TimeSlot ts) {
        BookingOrderLine cartItem = new BookingOrderLine(ts.getActivity(),
                ts.getStartDate(), ts.getEndDate(), ts.getStartTime(), ts.getEndTime(),
                ts.getId(), 1, 1 * ts.getActivity().getPrice());

        shoppingcarthandler.addToShoppingCart(cartItem);
        return "checkOut?faces-redirect=true";
    }
}
