/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextu.android.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Next University
 * @param <T> Tipo de entidad a manipular
 */
public interface IDAO<T> {
    
    void insertar(T entidad) throws SQLException;

    void eliminar(Integer id) throws SQLException;

    List<T> listar() throws SQLException;

    T buscar(Integer id) throws SQLException;

    void actualizar(T entidad) throws SQLException;
}
