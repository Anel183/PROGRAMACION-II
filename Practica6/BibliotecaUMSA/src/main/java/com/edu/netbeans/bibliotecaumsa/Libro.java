/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.bibliotecaumsa;

import java.util.ArrayList;

public class Libro {
    public String titulo;
    public String isbn;
    public ArrayList<Pagina> paginas = new ArrayList<>();

    public Libro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public void agregarPagina(int numero, String contenido) {
        paginas.add(new Pagina(numero, contenido));
    }

    @Override
    public String toString() {
        return titulo + " (ISBN: " + isbn + ") - " + paginas.size() + " páginas";
    }
}