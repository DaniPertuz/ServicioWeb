/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielpertuz.evaluacion.modelo;

/**
 *
 * @author DANIEL PERTUZ
 */
public class Tarea {
    int id, idEstudiante, idAsignatura;
    String nombre;
    double nota;

    public Tarea() {
    }

    public Tarea(int id, int idEstudiante, int idAsignatura, String nombre, double nota) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idAsignatura = idAsignatura;
        this.nombre = nombre;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
}
