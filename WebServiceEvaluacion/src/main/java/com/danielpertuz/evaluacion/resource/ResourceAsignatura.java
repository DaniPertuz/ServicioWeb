/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.evaluacion.resource;

import com.danielpertuz.evaluacion.modelo.Asignatura;
import com.danielpertuz.evaluacion.servicio.ServicioAsignatura;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DANIEL PERTUZ
 */
@Path("asignaturas")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ResourceAsignatura {
    
    ServicioAsignatura servicio = new ServicioAsignatura();
    
    @GET
    public List<Asignatura> getAsignaturas() {
        try {
            return servicio.getAsignaturas();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ResourceAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GET
    @Path("{asignaturaID}")
    public Asignatura getAsignatura(@PathParam("asignaturaID") int id) {
        try {
            return servicio.getAsignatura(id);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ResourceAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    public Asignatura addAsignatura(Asignatura asignatura) {
        return servicio.addAsignatura(asignatura);
    }
    
    @PUT
    @Path("{asignaturaID}")
    public Asignatura setAsignatura(@PathParam("asignaturaID") int id, Asignatura asignatura) {
        return servicio.setAsignatura(id, asignatura);
    }
    
    @DELETE
    @Path("{asignaturaID}")
    public Asignatura removeAsignatura(@PathParam("asignaturaID") int id) {
        return servicio.removeAsignatura(id);
    }
}
