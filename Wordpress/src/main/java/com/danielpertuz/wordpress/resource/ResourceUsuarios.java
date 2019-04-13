/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.wordpress.resource;

import com.danielpertuz.wordpress.modelo.Usuarios;
import com.danielpertuz.wordpress.service.ServicioUsuarios;
import java.util.List;
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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceUsuarios {
    
    ServicioUsuarios servicio = ServicioUsuarios.getInstance();
    
    @GET
    public List<Usuarios> getUsuario() {
        return servicio.getUsuarios();
    }
    
    @GET
    @Path("{usuarioID}")
    public Usuarios getUsuario(@PathParam("usuarioID") int id) {
        return servicio.getUsuario(id);
    }
    
    @POST
    public Usuarios addUsuario(Usuarios usuario) {
        return servicio.addUsuario(usuario);
    }
    
    @PUT
    @Path("{usuarioID}")
    public Usuarios setUsuario(@PathParam("usuarioID") int id, Usuarios usuario) {
        return servicio.setUsuario(id, usuario);
    }
    
    @DELETE
    @Path("{usuarioID}")
    public Usuarios removeUsuario(@PathParam("usuarioID") int id) {
        return servicio.removeUsuario(id);
    }
}
