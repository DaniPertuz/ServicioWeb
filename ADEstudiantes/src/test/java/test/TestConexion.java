/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.nextu.android.dao.Conexion;
import java.sql.SQLException;

/**
 *
 * @author DANIEL PERTUZ
 */
public class TestConexion {
    
    public static void main(String[] args) {
        try {
            if (Conexion.getInstance().existeConexion()){
                System.out.println("Conexión establecida");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
