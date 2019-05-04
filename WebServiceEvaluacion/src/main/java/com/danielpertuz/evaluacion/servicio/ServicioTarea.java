/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.evaluacion.servicio;

import com.danielpertuz.evaluacion.modelo.Conexion;
import com.danielpertuz.evaluacion.modelo.Tarea;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANIEL PERTUZ
 */
public class ServicioTarea {
    
    private final List<Tarea> tareas;
    
    private static ServicioTarea instancia;
    
    PreparedStatement insertar, listar, buscar, eliminar, actualizar;
    
    public static ServicioTarea getInstance() {
        if (instancia == null) {
            instancia = new ServicioTarea();
        }
        return instancia;
    }
    
    public ServicioTarea() {
        this.tareas = new ArrayList<>();
    }
    
    public List<Tarea> getTareas() throws SQLException, ClassNotFoundException {
        String sentencia = "SELECT * FROM tareas";
        
       if (listar == null) {
            listar = Conexion.getInstance().getCon().prepareStatement(sentencia);
        }
        ResultSet rs = listar.executeQuery();
        while(rs.next()) {
            tareas.add(cargar(rs));
        }
        return tareas;
    }
    
    public Tarea getTarea(int id) throws SQLException, ClassNotFoundException {
        String sentencia = "SELECT * FROM tareas WHERE id = ?";
        
        if (buscar == null) {
            buscar = Conexion.getInstance().getCon().prepareStatement(sentencia);
        }
        buscar.setInt(1, id);
        ResultSet rs = buscar.executeQuery();
        
        return rs != null && rs.next() ? cargar(rs) : null;
    }
    
    public Tarea addTarea(Tarea tarea) throws SQLException, ClassNotFoundException {
        String sentencia = "INSERT INTO tareas (id, nombre, nota, id_estudiante, id_asignaturas) VALUES (?,?,?,?,?)";
        if (insertar == null) {
            insertar = Conexion.getInstance().getCon().prepareStatement(sentencia);
        }
        
        insertar.setInt(1, tareas.size() - 1);
        insertar.setString(2, tarea.getNombre());
        insertar.setDouble(3, tarea.getNota());
        insertar.setInt(4, tarea.getIdEstudiante());
        insertar.setInt(5, tarea.getIdAsignatura());
        
        insertar.executeUpdate();
        tarea.setId(tareas.size() - 1);
        tareas.add(tarea);
        return tarea;
    }
    
    public Tarea setTarea(int id, Tarea tarea) throws SQLException, ClassNotFoundException {
        String sentencia = "UPDATE tareas SET nombre = ?, nota = ?, id_estudiante = ?, id_asignaturas = ?"
                + " WHERE id = ?";
        if (actualizar == null) {
            actualizar = Conexion.getInstance().getCon().prepareStatement(sentencia);
        }
        
        actualizar.setString(1, tarea.getNombre());
        actualizar.setDouble(2, tarea.getNota());
        actualizar.setInt(3, tarea.getIdEstudiante());
        actualizar.setInt(4, tarea.getIdAsignatura());
        
        actualizar.executeUpdate();
        tarea.setId(id - 1);
        tareas.set(id - 1, tarea);
        return tarea;
    }
    
    public Tarea removeTarea(int id) throws SQLException, ClassNotFoundException {
        String sentencia = "DELETE FROM tareas WHERE id = ?";
        if (eliminar == null) {
            eliminar = Conexion.getInstance().getCon().prepareStatement(sentencia);
        }
        
        eliminar.setInt(1, id);
        eliminar.executeUpdate();
        return tareas.remove(id - 1);
    }
    
    public Tarea cargar(ResultSet set) throws SQLException {
        Tarea tarea = new Tarea();
        
        tarea.setId(set.getInt("id"));
        tarea.setNombre(set.getString("nombre"));
        tarea.setNota(set.getDouble("nota"));
        tarea.setIdEstudiante(set.getInt("id_estudiante"));
        tarea.setIdAsignatura(set.getInt("id_asignaturas"));
        
        return tarea;
    }
}
