/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.evaluacion.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DANIEL PERTUZ
 */
public class Conexion {
    private Connection con;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String nombre = "root";
    private final String password = "Abc123**";
    private final String urlBaseDatos = "jdbc:mysql://localhost:3306/segundo_plano?serverTimezone=UTC";
    
    private static Conexion conexion;
    
    private Conexion() {
        
    }
    
    public static Conexion getInstance() throws SQLException, ClassNotFoundException {
        if (conexion == null) {
            conexion = new Conexion();
        }
        conexion.conectar();
        return conexion;
    }
    
    public void conectar() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(urlBaseDatos, nombre, password);
        }
    }
    
    public boolean existeConexion() throws SQLException {
        return con != null && !con.isClosed();
    }

    public Connection getCon() {
        return con;
    }
}
