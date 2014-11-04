/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.ordermanagement.entity;

import com.aviationhub.domain.activitymanagement.entity.Activity;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author ian
 */
@Entity
public class BookingOrderLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Activity activity;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date startTime;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date endTime;
    private Long timeSlotId;
    private int quantity;
    //in cents
    private int subTotal;

    /**
     *
     */
    public BookingOrderLine() {
    }

    /**
     *
     * @param activity
     * @param startDate
     * @param endDate
     * @param startTime
     * @param endTime
     * @param timeSlotId
     * @param quantity
     * @param subTotal
     */
    public BookingOrderLine(Activity activity, Date startDate, Date endDate, Date startTime, 
            Date endTime, Long timeSlotId, int quantity, int subTotal) {
        this.activity = activity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeSlotId = timeSlotId;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }
    
    /**
     *
     * @param src
     */
    public BookingOrderLine(BookingOrderLine src) {
        this.activity = src.getActivity();
        this.endDate = src.getEndDate();
        this.endTime = src.getEndTime();
        this.quantity = src.getQuantity();
        this.startDate = src.getStartDate();
        this.startTime = src.getStartTime();
        this.subTotal = src.getSubTotal();
        this.timeSlotId = src.getTimeSlotId();
    }
    
    /**
     *
     * @return
     */
    public Long getTimeSlotId() {
        return timeSlotId;
    }

    /**
     *
     * @param timeSlotId
     */
    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    /**
     *
     * @return
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     *
     * @param activity
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     *
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     *
     * @param startTime
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @return
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     *
     * @param endTime
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     *
     * @return
     */
    public int getSubTotal() {
        return subTotal;
    }

    /**
     *
     * @param subTotal
     */
    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingOrderLine)) {
            return false;
        }
        BookingOrderLine other = (BookingOrderLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aviationhub.domain.bookingmanagement.entity.ShoppingCartItem[ id=" + id + " ]";
    }

}
