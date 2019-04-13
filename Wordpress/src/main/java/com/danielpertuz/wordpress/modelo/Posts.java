/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.wordpress.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DANIEL PERTUZ
 */
@XmlRootElement
public class Posts {
    
    private int id, idUsuario;
    
    private String titulo, cuerpo;

    public Posts() {
    }

    public Posts(int id, int idUsuario, String titulo, String cuerpo) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

}
