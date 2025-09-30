package Practica4.Ejercicios;

import java.util.Random;

interface Coloreado {
    String comoColorear();
}

abstract class Figura {
    private String color;

    public Figura(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double area();
    public abstract double perimetro();

    @Override
    public String toString() {
        return "Color: " + color;
    }
}

class Cuadrado extends Figura implements Coloreado {
    private double lado;

    public Cuadrado(String color, double lado) {
        super(color);
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimetro() {
        return 4 * lado;
    }

    @Override
    public String comoColorear() {
        return "Colorear los cuatro lados";
    }

    @Override
    public String toString() {
        return "Cuadrado - " + super.toString() + ", Lado: " + lado;
    }
}

class Circulo extends Figura {
    private double radio;

    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI * radio * radio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String toString() {
        return "Círculo - " + super.toString() + ", Radio: " + radio;
    }
}

public class Ejercicio_2 {
    public static void main(String[] args) {
        Random rand = new Random();
        Figura[] figuras = new Figura[5];
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Negro"};

        for (int i = 0; i < figuras.length; i++) {
            int tipo = rand.nextInt(2) + 1; 
            String color = colores[rand.nextInt(colores.length)];

            if (tipo == 1) { 
                double lado = 1 + rand.nextDouble() * 10;
                figuras[i] = new Cuadrado(color, lado);
            } else { 
                double radio = 1 + rand.nextDouble() * 10;
                figuras[i] = new Circulo(color, radio);
            }
        }

        for (Figura f : figuras) {
            System.out.println("--------------------------------");
            System.out.println(f);
            System.out.printf("Área: %.2f\n", f.area());
            System.out.printf("Perímetro: %.2f\n", f.perimetro());

            if (f instanceof Coloreado) {
                System.out.println("Cómo colorear: " + ((Coloreado) f).comoColorear());
            }
        }
    }
}
