package practica1.ejercicios;
class Estadistica {
    private double[] numeros;
    public Estadistica(double[] numeros) {
        this.numeros = numeros;
    }

    public double promedio() {
        double suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma = suma + numeros[i];
        }
        return suma / numeros.length;
    }

    public double desviacion() {
        double prom = promedio();
        double sumaCuadrados = 0;
        for (int i = 0; i < numeros.length; i++) {
            double diferencia = numeros[i] - prom;
            sumaCuadrados = sumaCuadrados + (diferencia * diferencia);
        }
        double varianza = sumaCuadrados / (numeros.length - 1);
        return Math.sqrt(varianza);
    }
}

public class Ejercicio_3 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("");
        String linea = scanner.nextLine();
        java.util.StringTokenizer st = new java.util.StringTokenizer(linea);

        if (st.countTokens() != 10) {
            System.out.println("Error: Debe ingresar exactamente 10 números.");
            scanner.close();
            return;
        }

        double[] numeros = new double[10];
        for (int i = 0; i < 10; i++) {
            numeros[i] = Double.parseDouble(st.nextToken());
        }

        Estadistica estadistica = new Estadistica(numeros);

        double promedio = estadistica.promedio();
        double desviacion = estadistica.desviacion();

        System.out.printf("El promedio es %.2f%n", promedio);
        System.out.printf("La desviación estándar es %.5f%n", desviacion);

        scanner.close();
    }
}
    

