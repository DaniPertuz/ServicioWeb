/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.rest;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DANIEL PERTUZ
 */
@Path("mynewresources")
public class ResourceHeaderMatrix {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String httpGet(@HeaderParam("header") String header, @MatrixParam("matrix") String matrix) {
        return "Header param: " + header + " Matrix param: " + matrix;
    }
}
