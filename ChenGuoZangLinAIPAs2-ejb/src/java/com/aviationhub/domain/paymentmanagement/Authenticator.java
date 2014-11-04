/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.domain.paymentmanagement;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.DatatypeConverter;

/**
 * A HTTP basic access authentication helper class, adapted from the tutorial instruction
 * Reference:
 * Bien 2013, 'CLIENT-SIDE HTTP BASIC ACCESS AUTHENTICATION WITH JAX-RS 2.0', 03 September, 
 * viewed 30 December 2014, <http://www.adam-bien.com/roller/abien/entry/client_side_http_basic_access>.
 * @author ian
 */
public class Authenticator implements ClientRequestFilter {

    private final String user;
    private final String password;

    /**
     *
     * @param user
     * @param password
     */
    public Authenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    /**
     *
     * @param requestContext
     * @throws IOException
     */
    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        MultivaluedMap<String, Object> headers = requestContext.getHeaders();
        final String basicAuthentication = getBasicAuthentication();
        headers.add("Authorization", basicAuthentication);

    }

    private String getBasicAuthentication() {
        String token = this.user + ":" + this.password;
        try {
            return "BASIC " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new IllegalStateException("Cannot encode with UTF-8", ex);
        }
    }
}

