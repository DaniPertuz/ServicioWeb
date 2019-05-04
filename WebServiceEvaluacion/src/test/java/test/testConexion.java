/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.danielpertuz.evaluacion.modelo.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DANIEL PERTUZ
 */
public class testConexion {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            if (Conexion.getInstance().existeConexion()) {
                System.out.println("Conexion establecida");
            }
        } catch (SQLException e) {
            Logger.getLogger(testConexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
