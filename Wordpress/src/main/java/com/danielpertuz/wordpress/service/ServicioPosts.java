/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.wordpress.service;

import com.danielpertuz.wordpress.modelo.Posts;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANIEL PERTUZ
 */
public class ServicioPosts {
    
    private final List<Posts> posts;
    
    private static ServicioPosts instancia;
    
    public static ServicioPosts getInstance() {
        if (instancia == null) {
            instancia = new ServicioPosts();
        }
        return instancia;
    }

    public ServicioPosts() {
        this.posts = new ArrayList<>();
    }

    public List<Posts> getPosts() {
        return posts;
    }
    
    public Posts getPost(int id) {
        return posts.get(id - 1);
    }
    
    public Posts addPost(Posts post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }
    
    public Posts setPost(int id, Posts post) {
        post.setId(id - 1);
        posts.set(id - 1, post);
        return post;
    }
    
    public Posts removePost(int id) {
        return posts.remove(id - 1);
    }
}
