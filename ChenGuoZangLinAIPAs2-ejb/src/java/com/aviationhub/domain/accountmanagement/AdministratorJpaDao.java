/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.accountmanagement;

import com.aviationhub.domain.accountmanagement.entity.Administrator;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * A concrete JPA DAO for administrator entities
 *
 * @author ian
 */
@Dependent
public class AdministratorJpaDao implements AccountDao<Administrator>{

    @PersistenceContext(unitName = "ChenGuoZangLinAIPAs2-ejbPU")
    private EntityManager em;

    /**
     * Selects a administrator by given username and password
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public List<Administrator> read(String username, String password) {
        //constructs query
        Query query = em.createNamedQuery("findAdministrator");
        query.setParameter("username", username);
        query.setParameter("password", password);
        //fetches results
        List<Administrator> administrators = query.getResultList();
        //returns resault
        return administrators;
    }

    /**
     * Creates a new administrator
     * @param account
     */
    @Override
    public void create(Administrator account) {
        em.persist(account);
    }
}
