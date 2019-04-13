/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.rest;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DANIEL PERTUZ
 */

@Path("myresources")
public class MyResource {

    private static final Logger LOG = Logger.getLogger(MyResource.class.getName());    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String httpGet() {
        return "Mi primer servicio web";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String httpPost(String mensaje) {
        LOG.log(Level.INFO, "Se ha recibido el siguiente mensaje: {0}", mensaje);
        return "Método HTTP Post";
    }
    
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String httpPut(String mensaje) {
        LOG.info("Se ha ingresado al método HTTP PUT");
        LOG.log(Level.INFO, "Hemos recibido el siguiente mensaje: {0}", mensaje);
        return "Método HTTP Put";
    }
    
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String httpDelete(String mensaje) {
        LOG.info("Se ha ingresado al método HTTP DELETE");
        LOG.log(Level.INFO, "Hemos recibido el siguiente mensaje: {0}", mensaje);
        return "Método HTTP Delete";
    }
}
