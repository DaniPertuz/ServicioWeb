/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.evaluacion.servicio;

import com.danielpertuz.evaluacion.modelo.Asignatura;
import com.danielpertuz.evaluacion.modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANIEL PERTUZ
 */
public class ServicioAsignatura {
    
    private final List<Asignatura> asignaturas;
    
    private static ServicioAsignatura instancia;
    
    PreparedStatement listar, buscar;
    
    public static ServicioAsignatura getInstance() {
        if (instancia == null) {
            instancia = new ServicioAsignatura();
        }
        return instancia;
    }
    
    public ServicioAsignatura() {
        this.asignaturas = new ArrayList<>();
    }

    public List<Asignatura> getAsignaturas() throws SQLException, ClassNotFoundException {
        String sentencia = "SELECT * FROM asignaturas";
        
        if (listar == null) {
            listar = Conexion.getInstance().getCon().prepareStatement(sentencia);
        }
        ResultSet rs = listar.executeQuery();
        while(rs.next()) {
            asignaturas.add(cargar(rs));
        }
        
        return asignaturas;
    }
    
    public Asignatura getAsignatura(int id) throws SQLException, ClassNotFoundException {
        String sentencia = "SELECT * FROM asignaturas WHERE id = ?";
        
        if (buscar == null) {
            buscar = Conexion.getInstance().getCon().prepareStatement(sentencia);
        }
        buscar.setInt(1, id);
        ResultSet rs = buscar.executeQuery();
        
        return rs != null && rs.next() ? cargar(rs) : null;
    }
    
    public Asignatura addAsignatura(Asignatura asignatura) {
        asignatura.setId(asignaturas.size() - 1);
        asignaturas.add(asignatura);
        return asignatura;
    }
    
    public Asignatura setAsignatura(int id, Asignatura asignatura) {
        asignatura.setId(id - 1);
        asignaturas.set(id - 1, asignatura);
        return asignatura;
    }
    
    public Asignatura removeAsignatura(int id) {
        return asignaturas.remove(id - 1);
    }
    
    public Asignatura cargar(ResultSet set) throws SQLException {
        Asignatura asignatura = new Asignatura();
        
        asignatura.setId(set.getInt("id"));
        asignatura.setNombre(set.getString("nombre"));
        
        return asignatura;
    }
}
