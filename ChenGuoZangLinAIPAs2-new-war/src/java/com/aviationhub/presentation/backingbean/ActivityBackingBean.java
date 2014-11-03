/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.aviationhub.domain.activitymanagement.ActivityHandlerLocal;
import com.aviationhub.domain.activitymanagement.entity.PilotTraining;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.jboss.logging.Logger;

/**
 *
 * @author Zang
 */
@Named
@SessionScoped
public class ActivityBackingBean implements Serializable{
    @EJB
    private ActivityHandlerLocal activityhandler;
    @Inject
    private ShoppingCartBackingBean shoppingcart; 
    private PilotTraining detail;
    private long id;

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
 
    public PilotTraining getDetail() {
        return detail;
    }

    public void setDetail(PilotTraining detail) {
        this.detail = detail;
    }
    
    public void viewdetails(long id1){
        id = id1;
        detail=activityhandler.getPilotTrainingDetail(id);
    }
    
    public String book(){
        FacesContext fc= FacesContext.getCurrentInstance();
        Map<String,String> params= fc.getExternalContext().getRequestParameterMap();
        int ind= Integer.parseInt(params.get("ind"));
        
        //debug
        Logger log = Logger.getLogger(this.getClass().getName());
        log.log(Logger.Level.FATAL, ind);
        
        
        return shoppingcart.addToCart(detail.getTimeSlots().get(ind));
    }
}
