/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.bibliotecaumsa;

public class Prestamo {
    public String fechaPrestamo = "29/11/2025";
    public String fechaDevolucion = "13/12/2025";
    public Estudiante estudiante;
    public Libro libro;

    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
    }
}