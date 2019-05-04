/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.evaluacion.resource;

import com.danielpertuz.evaluacion.modelo.Usuario;
import com.danielpertuz.evaluacion.servicio.ServicioUsuario;
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
@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ResourceUsuario {

    ServicioUsuario servicio = new ServicioUsuario();

    @GET
    public List<Usuario> getUsuarios() {
        try {
            return servicio.getUsuarios();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ResourceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @GET
    @Path("{usuarioID}")
    public Usuario getUsuario(@PathParam("usuarioID") int id) {
        try {
            return servicio.getUsuario(id);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ResourceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @POST
    public Usuario addUsuario(Usuario usuario) {
        return servicio.addUsuario(usuario);
    }

    @PUT
    @Path("{usuarioID}")
    public Usuario setUsuario(@PathParam("usuarioID") int id, Usuario usuario) {
        return servicio.setUsuario(id, usuario);
    }

    @DELETE
    @Path("{usuarioID}")
    public Usuario removeUsuario(@PathParam("usuarioID") int id) {
        return servicio.removeUsuario(id);
    }
}
