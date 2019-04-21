/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextu.android.entidades;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Next University
 */
@XmlRootElement
public class Estudiante extends Persona{
    
    private int id;
    private String asignaturas;
    private boolean matriculado;

    public Estudiante() {
    }

    public Estudiante(String asignaturas, boolean matriculado, 
            int identificacion, String nombre, String apellidos, int edad) {
        
        super(identificacion, nombre, apellidos, edad);
        
        this.asignaturas = asignaturas;
        this.matriculado = matriculado;
    }

    public Estudiante(int id, String asignaturas, boolean matriculado, 
            int identificacion, String nombre, String apellidos, int edad) {
        super(identificacion, nombre, apellidos, edad);
        this.id = id;
        this.asignaturas = asignaturas;
        this.matriculado = matriculado;
    }
    
    public Estudiante(Persona persona, String asignaturas, boolean matriculado) {
        
        super(persona.getIdentificacion(), persona.getNombre(), 
                persona.getApellidos(), persona.getEdad());

        this.asignaturas = asignaturas;
        this.matriculado = matriculado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(String asignaturas) {
        this.asignaturas = asignaturas;
    }

    public boolean isMatriculado() {
        return matriculado;
    }

    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }

    @Override
    public String toString() {
        return super.toString()+"Id Estudiante: " + id + "\nAsignaturas: " + asignaturas + 
                "\nmatriculado: " + matriculado + "\n";
    }
}
