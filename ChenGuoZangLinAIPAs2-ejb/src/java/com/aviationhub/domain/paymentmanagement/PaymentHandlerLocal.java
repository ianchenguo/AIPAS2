/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement;

import javax.ejb.Local;

/**
 *
 * @author ian
 */
@Local
public interface PaymentHandlerLocal {
    public void charge();
}
