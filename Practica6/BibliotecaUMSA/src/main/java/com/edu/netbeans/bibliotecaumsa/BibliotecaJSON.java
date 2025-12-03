/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.bibliotecaumsa;

import com.google.gson.Gson;
import java.io.*;

public class BibliotecaJSON {
    private static final String RUTA = "datos/biblioteca.json";
    private static final Gson gson = new Gson();

    static {
        new File("datos").mkdirs(); 
    }

    public static void guardar(Biblioteca b) {
        try (FileWriter writer = new FileWriter(RUTA)) {
            gson.toJson(b, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    public static Biblioteca cargar() {
        File file = new File(RUTA);
        if (!file.exists()) {
            return new Biblioteca("Biblioteca Central UMSA", "Lun-Vie", "08:00", "19:00");
        }
        try (FileReader reader = new FileReader(RUTA)) {
            return gson.fromJson(reader, Biblioteca.class);
        } catch (IOException e) {
            System.err.println("Error al cargar: " + e.getMessage());
            return new Biblioteca("Biblioteca Central UMSA", "Lun-Vie", "08:00", "19:00");
        }
    }
}