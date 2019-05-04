/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.evaluacion.resource;

import com.danielpertuz.evaluacion.modelo.Tarea;
import com.danielpertuz.evaluacion.servicio.ServicioTarea;
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
@Path("tareas")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ResourceTarea {
    
    ServicioTarea servicio = new ServicioTarea();
    
    @GET
    public List<Tarea> getTareas() {
        try {
            return servicio.getTareas();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ResourceTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GET
    @Path("{tareaID}")
    public Tarea getTarea(@PathParam("tareaID") int id) {
        try {
            return servicio.getTarea(id);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ResourceTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    public Tarea addTarea(Tarea tarea) {
        try {
            return servicio.addTarea(tarea);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ResourceTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @PUT
    @Path("{tareaID}")
    public Tarea setTarea(@PathParam("tareaID") int id, Tarea tarea) {
        try {
            return servicio.setTarea(id, tarea);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ResourceTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @DELETE
    @Path("{tareaID}")
    public Tarea removeTarea(@PathParam("tareaID") int id) {
        try {
            return servicio.removeTarea(id);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ResourceTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
