/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.evaluacion.servicio;

import com.danielpertuz.evaluacion.modelo.Conexion;
import com.danielpertuz.evaluacion.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANIEL PERTUZ
 */
public class ServicioUsuario {
    
    private final List<Usuario> usuarios, estudiantes;
    
    private static ServicioUsuario instancia;
    
    PreparedStatement listar, buscar, estudiante;
    
    public static ServicioUsuario getInstance() {
        if (instancia == null) {
            instancia = new ServicioUsuario();
        }
        return instancia;
    }
    
    public ServicioUsuario() {
        this.usuarios = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }
    
    public List<Usuario> getUsuarios() throws SQLException, ClassNotFoundException {
        String sentencia = "SELECT * FROM usuarios";
        
        if (listar == null) {
            listar = Conexion.getInstance().getCon().prepareStatement(sentencia);
        }
        ResultSet rs = listar.executeQuery();
        while(rs.next()) {
            usuarios.add(cargar(rs));
        }
        
        return usuarios;
    }
    
    public Usuario getUsuario(int id) throws SQLException, ClassNotFoundException {
        String sentencia = "SELECT * FROM usuarios WHERE id = ?";
        if (buscar == null) {
            buscar = Conexion.getInstance().getCon().prepareStatement(sentencia);
        }
        buscar.setInt(1, id);
        ResultSet rs = buscar.executeQuery();
        
        return rs != null && rs.next() ? cargar(rs) : null;
    }
    
    public Usuario addUsuario(Usuario usuario) {
        usuario.setId(usuarios.size() - 1);
        usuarios.add(usuario);
        return usuario;
    }
    
    public Usuario setUsuario(int id, Usuario usuario) {
        usuario.setId(id - 1);
        usuarios.set(id - 1, usuario);
        return usuario;
    }
    
    public Usuario removeUsuario(int id) {
        return usuarios.remove(id - 1);
    }
    
    public Usuario cargar(ResultSet set) throws SQLException {
        Usuario usuario = new Usuario();
        
        usuario.setId(set.getInt("id"));
        usuario.setNombre(set.getString("nombre"));
        usuario.setPassword(set.getString("password"));
        usuario.setRol(set.getString("rol"));
        
        return usuario;
    }
}
