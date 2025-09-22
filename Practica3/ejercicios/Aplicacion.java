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
        this.numeroDeVidas = 3; // Reinicia a 3 vidas
        System.out.println("Se ha iniciado una nueva partida.");
    }

    public void actualizaRecord() {
        this.record++;
        System.out.println("¡Nuevo record! Vidas restantes: " + this.numeroDeVidas);
    }

    public boolean quitaVida() {
        this.numeroDeVidas--;
        return this.numeroDeVidas > 0;
    }
}

class JuegoAdivinaNumero extends Juego {
    protected int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public boolean validaNumero(int numero) {
        return numero >= 0 && numero <= 10;
    }

    public void juega(Scanner scanner) {
        reiniciaPartida();
        Random rand = new Random();
        numeroAAdivinar = rand.nextInt(11); // Genera número entre 0 y 10

        while (true) {
            System.out.println("Adivina un número entre 0 y 10.");
            System.out.print("Introduce tu número: ");
            int intento;
            try {
                intento = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
                scanner.nextLine(); // Limpiar el buffer
                continue;
            }

            if (!validaNumero(intento)) {
                System.out.println("El número debe estar entre 0 y 10. Intenta de nuevo.");
                continue;
            }

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

class JuegoAdivinaPar extends JuegoAdivinaNumero {
    public JuegoAdivinaPar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public boolean validaNumero(int numero) {
        if (numero >= 0 && numero <= 10) {
            if (numero % 2 == 0) {
                return true;
            } else {
                System.out.println("Error: El número debe ser par.");
                return false;
            }
        } else {
            System.out.println("El número debe estar entre 0 y 10.");
            return false;
        }
    }
}

class JuegoAdivinaImpar extends JuegoAdivinaNumero {
    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public boolean validaNumero(int numero) {
        if (numero >= 0 && numero <= 10) {
            if (numero % 2 != 0) {
                return true;
            } else {
                System.out.println("Error: El número debe ser impar.");
                return false;
            }
        } else {
            System.out.println("El número debe estar entre 0 y 10.");
            return false;
        }
    }
}

public class Aplicacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Juego Adivina Número ===");
        JuegoAdivinaNumero juego1 = new JuegoAdivinaNumero(3);
        juego1.juega(scanner);

        System.out.println("\n=== Juego Adivina Par ===");
        JuegoAdivinaPar juego2 = new JuegoAdivinaPar(3);
        juego2.juega(scanner);

        System.out.println("\n=== Juego Adivina Impar ===");
        JuegoAdivinaImpar juego3 = new JuegoAdivinaImpar(3);
        juego3.juega(scanner);

        scanner.close();
    }
}