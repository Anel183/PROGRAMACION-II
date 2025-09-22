package Practica3.ejercicios;

import java.util.Random;
import java.util.Scanner;

class Juego {
    protected int numeroDeVidas;
    protected int record;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        this.numeroDeVidas = 3; 
    }

    public void actualizaRecord() {
        this.record++;
    }

    public boolean quitaVida() {
        this.numeroDeVidas--;
        return this.numeroDeVidas > 0;
    }
}

class JuegoAdivinaNumero extends Juego {
    private int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public void juega() {
        reiniciaPartida();
        Random rand = new Random();
        numeroAAdivinar = rand.nextInt(11); 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Adivina un número entre 0 y 10:");
            int intento = scanner.nextInt();

            if (intento == numeroAAdivinar) {
                System.out.println("¡Acertaste!");
                actualizaRecord();
                break;
            } else {
                boolean vidasRestantes = quitaVida();
                if (vidasRestantes) {
                    if (intento < numeroAAdivinar) {
                        System.out.println("El número es mayor. Intenta de nuevo.");
                    } else {
                        System.out.println("El número es menor. Intenta de nuevo.");
                    }
                } else {
                    System.out.println("No te quedan más vidas. ¡Fin del juego!");
                    break;
                }
            }
        }
    }
}

public class Ejercicio_1 {
    public static void main(String[] args) {
        JuegoAdivinaNumero juego = new JuegoAdivinaNumero(3);
        juego.juega();
    }
}