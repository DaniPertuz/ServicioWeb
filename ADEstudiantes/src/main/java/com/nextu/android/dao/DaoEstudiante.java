/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextu.android.dao;

import com.nextu.android.entidades.Estudiante;
import com.nextu.android.entidades.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Next University
 */
public class DaoEstudiante implements IDAO<Estudiante> {

    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    private static DaoEstudiante instacia;

    private DaoEstudiante() {

    }

    public static DaoEstudiante getInstance() {
        if (instacia == null) {
            instacia = new DaoEstudiante();
        }
        return instacia;
    }

    @Override
    public void insertar(Estudiante entidad) throws SQLException {
        DaoPersona.getInstance().insertar(entidad);
        String query = "INSERT INTO estudiante (persona_id, asignaturas, matriculado) VALUES (?, ?, ?)";

        if (insertar == null) {
            insertar = Conexion.getInstance().getConnection().prepareStatement(query);
        }

        insertar.setInt(1, entidad.getIdentificacion());
        insertar.setString(2, ((Estudiante) entidad).getAsignaturas());
        insertar.setBoolean(3, ((Estudiante) entidad).isMatriculado());

        insertar.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String query = "DELETE FROM estudiante WHERE id = ?";
        
        if (eliminar == null) {
            eliminar = Conexion.getInstance().getConnection().prepareStatement(query);
        }
        
        eliminar.setInt(1, id);
        eliminar.executeUpdate();
    }

    @Override
    public List<Estudiante> listar() throws SQLException {
        String query = "SELECT * FROM estudiante";
        
        if (listar == null) {
            listar = Conexion.getInstance().getConnection().prepareStatement(query);
        }
        
        ResultSet set = listar.executeQuery();
        ArrayList<Estudiante> result = new ArrayList<>();
        while(set.next()){
            result.add(cargar(set));
        }
        
        return result;
    }

    @Override
    public Estudiante buscar(Integer id) throws SQLException {
        String query = "SELECT * FROM estudiante WHERE id = ?";
        
        if (buscar == null) {
            buscar = Conexion.getInstance().getConnection().prepareStatement(query);
        }
        
        buscar.setInt(1, id);
        
        ResultSet set = buscar.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;
    }

    @Override
    public void actualizar(Estudiante entidad) throws SQLException {
        DaoPersona.getInstance().actualizar(entidad);
        String query = "UPDATE estudiante SET asignaturas=?, matriculado=? "
                + "WHERE id = ?";
        
        if (actualizar == null) {
            actualizar = Conexion.getInstance().getConnection().prepareStatement(query);
        }
        
        actualizar.setString(1, entidad.getAsignaturas());
        actualizar.setBoolean(2, entidad.isMatriculado());
        actualizar.setInt(3, entidad.getId());
        
        actualizar.executeUpdate();
    }
    
    public Estudiante cargar(ResultSet set) throws SQLException{
        
        //Datos Estudiante
        Estudiante estudiante = new Estudiante();
        estudiante.setId(set.getInt("id"));
        estudiante.setAsignaturas(set.getString("asignaturas"));
        estudiante.setMatriculado(set.getBoolean("matriculado"));
        
        //Datos Persona
        Persona persona = DaoPersona.getInstance().buscar(
                set.getInt("persona_id"));
        estudiante.setIdentificacion(persona.getIdentificacion());
        estudiante.setNombre(persona.getNombre());
        estudiante.setApellidos(persona.getApellidos());
        estudiante.setEdad(persona.getEdad());
        
        return estudiante;
    }
    
}
