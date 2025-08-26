package practica1.ejercicios;
class EcuacionLineal {
    private double a, b, c, d, e, f;

    public EcuacionLineal(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public boolean tieneSolucion() {
        double determinante = a * d - b * c;
        return determinante != 0;
    }

    public double getX() {
        double determinante = a * d - b * c;
        return (e * d - b * f) / determinante;
    }

    public double getY() {
        double determinante = a * d - b * c;
        return (a * f - e * c) / determinante;
    }
}
public class Ejercicio_1 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Ingrese a,b,c,d,e,f:");
        String linea = scanner.nextLine();
        java.util.StringTokenizer st = new java.util.StringTokenizer(linea);

        if (st.countTokens() != 6) {
            System.out.println("");
            scanner.close();
            return;
        }

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());
        double d = Double.parseDouble(st.nextToken());
        double e = Double.parseDouble(st.nextToken());
        double f = Double.parseDouble(st.nextToken());

        EcuacionLineal ecuacion = new EcuacionLineal(a, b, c, d, e, f);


        if (ecuacion.tieneSolucion()) {
            double x = ecuacion.getX();
            double y = ecuacion.getY();
            System.out.printf("x = %.1f, y = %.1f%n", x, y);
        } else {
            System.out.println("La ecuación no tiene solución.");
        }

        scanner.close();
    }
}