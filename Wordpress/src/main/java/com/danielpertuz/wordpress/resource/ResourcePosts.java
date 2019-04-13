/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.wordpress.resource;

import com.danielpertuz.wordpress.modelo.Posts;
import com.danielpertuz.wordpress.service.ServicioPosts;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DANIEL PERTUZ
 */
@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResourcePosts {

    ServicioPosts servicio = ServicioPosts.getInstance();

    @GET
    public List<Posts> getPosts() {
        return servicio.getPosts();
    }

    @GET
    @Path("{postID}")
    public Posts getPost(@PathParam("postID") int id) {
        return servicio.getPost(id);
    }

    @POST
    public Posts addPost(Posts post) {
        return servicio.addPost(post);
    }

    @PUT
    @Path("{postID}")
    public Posts setPost(@PathParam("postID") int id, Posts post) {
        return servicio.setPost(id, post);
    }

    @DELETE
    @Path("{postID}")
    public Posts removePost(@PathParam("postID") int id) {
        return servicio.removePost(id);
    }
}
