package Practica4.Ejercicios;

import java.util.Scanner;
abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double CalcularSalarioMensual();

    @Override
    public String toString() {
        return "Nombre: " + nombre;
    }
}

class EmpleadoTiempoCompleto extends Empleado {
    private double salarioAnual;

    public EmpleadoTiempoCompleto(String nombre, double salarioAnual) {
        super(nombre);
        this.salarioAnual = salarioAnual;
    }

    @Override
    public double CalcularSalarioMensual() {
        return salarioAnual / 12.0;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Salario Anual: " + salarioAnual +
               ", Salario Mensual: " + CalcularSalarioMensual();
    }
}

class EmpleadoTiempoHorario extends Empleado {
    private double horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoTiempoHorario(String nombre, double horasTrabajadas, double tarifaPorHora) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double CalcularSalarioMensual() {
        return horasTrabajadas * tarifaPorHora;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Horas trabajadas: " + horasTrabajadas +
               ", Tarifa por hora: " + tarifaPorHora +
               ", Salario Mensual: " + CalcularSalarioMensual();
    }
}

public class Ejercicio_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empleado[] empleados = new Empleado[5];

        // 3 empleados a tiempo completo
        for (int i = 0; i < 3; i++) {
            System.out.print("Nombre del empleado tiempo completo #" + (i + 1) + ": ");
            String nombre = sc.nextLine();
            System.out.print("Salario anual: ");
            double salarioAnual = sc.nextDouble();
            sc.nextLine(); // limpiar salto de línea
            empleados[i] = new EmpleadoTiempoCompleto(nombre, salarioAnual);
        }

        for (int i = 3; i < 5; i++) {
            System.out.print("Nombre del empleado por horas #" + (i - 2) + ": ");
            String nombre = sc.nextLine();
            System.out.print("Horas trabajadas: ");
            double horas = sc.nextDouble();
            System.out.print("Tarifa por hora: ");
            double tarifa = sc.nextDouble();
            sc.nextLine(); // limpiar salto de línea
            empleados[i] = new EmpleadoTiempoHorario(nombre, horas, tarifa);
        }

        sc.close();

        System.out.println("\n--- Lista de Empleados ---");
        for (Empleado e : empleados) {
            System.out.println(e.getNombre() + " - Salario mensual: " + e.CalcularSalarioMensual());
        }
    }
}
