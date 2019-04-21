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
 * @version 1.0
 */
@XmlRootElement
public class Persona {
    
    protected int identificacion;
    protected String nombre;
    protected String apellidos;
    protected int edad;

    public Persona() {
    }

    public Persona(int identificacion, String nombre, String apellidos, int edad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "\nIdentificacion: " + identificacion + "\nNombre: " + nombre + 
                "\nApellidos: " + apellidos + "\nEdad: " + edad + "\n";
    }
    
    
}
