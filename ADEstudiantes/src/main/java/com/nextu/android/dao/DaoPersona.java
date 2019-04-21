/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextu.android.dao;

import com.nextu.android.entidades.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Next University
 * @version 1.0
 */
public class DaoPersona implements IDAO<Persona> {

    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    private static DaoPersona instacia;

    private DaoPersona() {

    }

    public static DaoPersona getInstance() {
        if (instacia == null) {
            instacia = new DaoPersona();
        }
        return instacia;
    }

    @Override
    public void insertar(Persona entidad) throws SQLException {
        String query = "INSERT INTO persona (identificacion, nombre, apellidos, edad) VALUES (?, ?, ?, ?)";

        if (insertar == null) {
            insertar = Conexion.getInstance().getConnection().prepareStatement(query);
        }

        insertar.setInt(1, entidad.getIdentificacion());
        insertar.setString(2, entidad.getNombre());
        insertar.setString(3, entidad.getApellidos());
        insertar.setInt(4, entidad.getEdad());

        insertar.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String query = "DELETE FROM persona WHERE identificacion = ?";
        
        if (eliminar == null) {
            eliminar = Conexion.getInstance().getConnection().prepareStatement(query);
        }
        
        eliminar.setInt(1, id);
        eliminar.executeUpdate();
    }

    @Override
    public List<Persona> listar() throws SQLException {
        String query = "SELECT * FROM persona";
        
        if (listar == null) {
            listar = Conexion.getInstance().getConnection().prepareStatement(query);
        }
        
        ResultSet set = listar.executeQuery();
        ArrayList<Persona> result = new ArrayList<>();
        while(set.next()){
            result.add(cargar(set));
        }
        
        return result;
    }

    @Override
    public Persona buscar(Integer id) throws SQLException {
        String query = "SELECT * FROM persona WHERE identificacion = ?";
        
        if (buscar == null) {
            buscar = Conexion.getInstance().getConnection().prepareStatement(query);
        }
        
        buscar.setInt(1, id);
        
        ResultSet set = buscar.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;
    }

    @Override
    public void actualizar(Persona entidad) throws SQLException {
        String query = "UPDATE persona SET nombre=?, apellidos=?, edad=? "
                + "WHERE identificacion = ?";
        
        if (actualizar == null) {
            actualizar = Conexion.getInstance().getConnection().prepareStatement(query);
        }
        
        actualizar.setString(1, entidad.getNombre());
        actualizar.setString(2, entidad.getApellidos());
        actualizar.setInt(3, entidad.getEdad());
        actualizar.setInt(4, entidad.getIdentificacion());
        
        actualizar.executeUpdate();
    }
    
    public Persona cargar(ResultSet set) throws SQLException{
        
        Persona persona = new Persona();
        
        persona.setIdentificacion(set.getInt("identificacion"));
        persona.setEdad(set.getInt("edad"));
        persona.setNombre(set.getString("nombre"));
        persona.setApellidos(set.getString("apellidos"));
        
        return persona;
    }
}
