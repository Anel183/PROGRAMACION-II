package practica1.ejercicios;

class EcuacionCuadratica {
    private double a, b, c;

    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return b * b - 4 * a * c;
    }

    public double getRaiz1() {
        double discriminante = getDiscriminante();
        if (discriminante < 0) {
            return 0;
        }
        return (-b + Math.sqrt(discriminante)) / (2 * a);
    }

    public double getRaiz2() {
        double discriminante = getDiscriminante();
        if (discriminante < 0) {
            return 0;
        }
        return (-b - Math.sqrt(discriminante)) / (2 * a);
    }
}

public class Ejercicio_2 {
     public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Ingrese a,b,c:");
        String linea = scanner.nextLine();
        java.util.StringTokenizer st = new java.util.StringTokenizer(linea);

        if (st.countTokens() != 3) {
            System.out.println("");
            scanner.close();
            return;
        }

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        EcuacionCuadratica ecuacion = new EcuacionCuadratica(a, b, c);

        double discriminante = ecuacion.getDiscriminante();

        if (discriminante > 0) {
            double raiz1 = ecuacion.getRaiz1();
            double raiz2 = ecuacion.getRaiz2();
            System.out.printf("La ecuación tiene dos raíces %.6f y %.6f%n", raiz1, raiz2);
        } else if (discriminante == 0) {
            double raiz = ecuacion.getRaiz1();
            System.out.printf("La ecuación tiene una raíz %.6f%n", raiz);
        } else {
            System.out.println("La ecuación no tiene raíces reales.");
        }

        scanner.close();
    }
}
    
    

