/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.custommoodle.model;

import java.util.List;

/**
 *
 * @author Red
 */
public class Materia {
    private List<Student> alumnos;
    private String nombre;
    private String docente;

    public List<Student> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Student> alumnos) {
        this.alumnos = alumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String geDocente() {
        return docente;
    }

    public void setDocente(String ocente) {
        this.docente = ocente;
    }
    
    
}
