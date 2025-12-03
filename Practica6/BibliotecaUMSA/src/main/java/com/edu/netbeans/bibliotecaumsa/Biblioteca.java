/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.bibliotecaumsa;
import java.util.ArrayList;

public class Biblioteca {
    public String nombre;
    public Horario horario;
    public ArrayList<Libro> libros = new ArrayList<>();
    public ArrayList<Autor> autores = new ArrayList<>();
    public ArrayList<Prestamo> prestamos = new ArrayList<>();

    public Biblioteca(String nombre, String dias, String apertura, String cierre) {
        this.nombre = nombre;
        this.horario = new Horario(dias, apertura, cierre);
    }

    public void agregarLibro(Libro libro) { libros.add(libro); }
    public void agregarAutor(Autor autor) { autores.add(autor); }

    public void prestarLibro(Estudiante estudiante, Libro libro) {
        if (libros.contains(libro)) {
            prestamos.add(new Prestamo(estudiante, libro));
        }
    }
}