/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.bibliotecaumsa;
public class Horario {
    public String dias;
    public String horaApertura;
    public String horaCierre;

    public Horario(String dias, String horaApertura, String horaCierre) {
        this.dias = dias;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    @Override
    public String toString() {
        return dias + " de " + horaApertura + " a " + horaCierre;
    }
}
