/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextu.android.recursos;

import com.nextu.android.dao.DaoPersona;
import com.nextu.android.entidades.Persona;
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
 * @author Next University
 */
@Path("personas")
public class RecursoPersona {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> get(){
        try {
            return DaoPersona.getInstance().listar();
            
        } catch (SQLException ex) {
            Logger.getLogger(RecursoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Persona persona){
        try {
            DaoPersona.getInstance().insertar(persona);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getPersonaById(@PathParam("id")Integer id){
        try {
            return DaoPersona.getInstance().buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")Integer id){
        try {
            DaoPersona.getInstance().eliminar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{id}")
    public void put(@PathParam("id")Integer id, Persona persona){
        persona.setIdentificacion(id);
        try {
            DaoPersona.getInstance().actualizar(persona);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
