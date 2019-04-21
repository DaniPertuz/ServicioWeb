/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextu.android.recursos;

import com.nextu.android.dao.DaoEstudiante;
import com.nextu.android.entidades.Estudiante;
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
 * @version 1.0
 */

@Path("estudiantes")
public class RecursoEstudiante {
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Estudiante> get(){
        try {
            return DaoEstudiante.getInstance().listar();
            
        } catch (SQLException ex) {
            Logger.getLogger(RecursoEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Estudiante estudiante){
        try {
            DaoEstudiante.getInstance().insertar(estudiante);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Estudiante getEstudianteById(@PathParam("id")Integer id){
        try {
            return DaoEstudiante.getInstance().buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")Integer id){
        try {
            DaoEstudiante.getInstance().eliminar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{id}")
    public void put(@PathParam("id")Integer id, Estudiante estudiante){
        estudiante.setId(id);
        try {
            DaoEstudiante.getInstance().actualizar(estudiante);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
