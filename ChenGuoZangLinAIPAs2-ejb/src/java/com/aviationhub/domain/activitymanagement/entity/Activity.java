/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.activitymanagement.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * An abstract activity entity
 * @author ian
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ACTIVITYTYPE")
public abstract class Activity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private ActivityTypeEnum activityType;
    //in cents
    private int price;
    private String provider;
    private String aircraft;
    @Enumerated(EnumType.STRING)
    private ActivityStateEnum activityState;
    private String imageUrl;
    private String activityDesc;
    
    @OneToMany(mappedBy = "activity")
    private List<TimeSlot> timeSlots;

    //getters and setters

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

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public ActivityTypeEnum getActivityType() {
        return activityType;
    }

    /**
     *
     * @param activityType
     */
    public void setActivityType(ActivityTypeEnum activityType) {
        this.activityType = activityType;
    }

    /**
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String getProvider() {
        return provider;
    }

    /**
     *
     * @param provider
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     *
     * @return
     */
    public String getAircraft() {
        return aircraft;
    }

    /**
     *
     * @param aircraft
     */
    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    /**
     *
     * @return
     */
    public ActivityStateEnum getActivityState() {
        return activityState;
    }

    /**
     *
     * @param activityState
     */
    public void setActivityState(ActivityStateEnum activityState) {
        this.activityState = activityState;
    }

    /**
     *
     * @return
     */
    public String getActivityDesc() {
        return activityDesc;
    }

    /**
     *
     * @param activityDesc
     */
    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    /**
     *
     * @return
     */
    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    /**
     *
     * @param timeSlots
     */
    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    /**
     *
     * @return
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     *
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aviationhub.domain.activitymanagement.entity.Activity[ id=" + id + " ]";
    }
    
}
