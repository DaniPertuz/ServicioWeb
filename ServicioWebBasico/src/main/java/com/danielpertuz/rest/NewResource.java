/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DANIEL PERTUZ
 */
@Path("newresources")
public class NewResource {
    
    @GET
    //@Path("{parametro1}")
    @Produces(MediaType.TEXT_PLAIN)
    public String httpGet(@QueryParam("query") String param, @QueryParam("query2") String param2) {
        return "Query param: " + param + " " + param2;
    }
    /*public String httpGet(@PathParam("parametro1") String paramPath) {
        return "Parametro de ruta " + paramPath;
    }*/
}
