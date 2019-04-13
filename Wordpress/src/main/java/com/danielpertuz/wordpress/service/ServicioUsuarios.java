/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.wordpress.service;

import com.danielpertuz.wordpress.modelo.Usuarios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANIEL PERTUZ
 */
public class ServicioUsuarios {
    
    private final List<Usuarios> usuarios;
    
    private static ServicioUsuarios instancia;
    
    public static ServicioUsuarios getInstance() {
        if (instancia == null) {
            instancia = new ServicioUsuarios();
        }
        return instancia;
    }

    public ServicioUsuarios() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuarios(1, "Daniel Pertuz", "DaniPertuz", "ddpertuzoroz@hotmail.com", "https://facebook.com/DaniPertuz", "https://twitter.com/DaniPertuz"));
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }
    
    public Usuarios getUsuario(int id) {
        return usuarios.get(id - 1);
    }
    
    public Usuarios addUsuario(Usuarios usuario) {
        usuario.setId(usuarios.size() + 1);
        usuarios.add(usuario);
        return usuario;
    }
    
    public Usuarios setUsuario(int id, Usuarios usuario) {
        usuario.setId(id);
        usuarios.set(id - 1, usuario);
        return usuario;
    }
    
    public Usuarios removeUsuario(int id) {
        return usuarios.remove(id - 1);
    }
}
