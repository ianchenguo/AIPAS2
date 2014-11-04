/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.ordermanagement.entity;

import com.aviationhub.domain.accountmanagement.entity.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author ian
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "getOrdersByAccountAndStatus",
            query = "select o from BookingOrder o "
            + "where o.account = :account and o.orderStatus = :status"),
    @NamedQuery(name = "getOrdersByAccount",
            query = "select o from BookingOrder o "
            + "where o.account = :account"),
    @NamedQuery(name = "getAllOrders",
            query = "select o from BookingOrder o")})

public class BookingOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //price in cents
    private long totalPrice;
    @OneToMany(cascade = CascadeType.ALL)
    private List<BookingOrderLine> orderLines;
    @ManyToOne
    private Customer account;
    private String firstName;
    private String lastName;
    @ManyToOne(cascade = CascadeType.ALL)
    private BookingOrderAddress address;
    private String landLineNo;
    private String cellPhoneNo;
    private String email;
    @Enumerated(EnumType.STRING)
    private BookingOrderStatusEnum orderStatus;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date placeTime;
    private String ipAddress;

    /**
     *
     */
    public BookingOrder() {
        this.orderLines = new ArrayList<>();
    }

    /**
     *
     * @param totalPrice
     * @param orderLines
     * @param account
     * @param firstName
     * @param lastName
     * @param address
     * @param landLineNo
     * @param cellPhoneNo
     * @param email
     * @param orderStatus
     * @param placeTime
     * @param ipAddress
     */
    public BookingOrder(long totalPrice, List<BookingOrderLine> orderLines, Customer account, String firstName, String lastName, BookingOrderAddress address, String landLineNo, String cellPhoneNo, String email, BookingOrderStatusEnum orderStatus, Date placeTime, String ipAddress) {
        this.totalPrice = totalPrice;
        this.orderLines = orderLines;
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.landLineNo = landLineNo;
        this.cellPhoneNo = cellPhoneNo;
        this.email = email;
        this.orderStatus = orderStatus;
        this.placeTime = placeTime;
        this.ipAddress = ipAddress;
    }

    /**
     *
     * @return
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     *
     * @param ipAddress
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public long getTotalPrice() {
        return totalPrice;
    }

    /**
     *
     * @param totalPrice
     */
    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     *
     * @return
     */
    public List<BookingOrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     *
     * @param orderLines
     */
    public void setOrderLines(List<BookingOrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    /**
     *
     * @return
     */
    public Customer getAccount() {
        return account;
    }

    /**
     *
     * @param account
     */
    public void setAccount(Customer account) {
        this.account = account;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public BookingOrderAddress getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(BookingOrderAddress address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getLandLineNo() {
        return landLineNo;
    }

    /**
     *
     * @param landLineNo
     */
    public void setLandLineNo(String landLineNo) {
        this.landLineNo = landLineNo;
    }

    /**
     *
     * @return
     */
    public String getCellPhoneNo() {
        return cellPhoneNo;
    }

    /**
     *
     * @param cellPhoneNo
     */
    public void setCellPhoneNo(String cellPhoneNo) {
        this.cellPhoneNo = cellPhoneNo;
    }

    /**
     *
     * @return
     */
    public BookingOrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    /**
     *
     * @param orderStatus
     */
    public void setOrderStatus(BookingOrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     *
     * @return
     */
    public Date getPlaceTime() {
        return placeTime;
    }

    /**
     *
     * @param placeTime
     */
    public void setPlaceTime(Date placeTime) {
        this.placeTime = placeTime;
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
        if (!(object instanceof BookingOrder)) {
            return false;
        }
        BookingOrder other = (BookingOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aviationhub.domain.paymentmanagement.Entity.Order[ id=" + id + " ]";
    }

}
