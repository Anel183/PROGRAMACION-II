package Practica2.ejercicios;

class Vector3D {
    private double x, y, z;

    public Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public Vector3D add(Vector3D v) {
        return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public Vector3D subtract(Vector3D v) {
        return new Vector3D(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    public double dot(Vector3D v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public Vector3D cross(Vector3D v) {
        return new Vector3D(
            this.y * v.z - this.z * v.y,
            this.z * v.x - this.x * v.z,
            this.x * v.y - this.y * v.x
        );
    }

    public double magnitude() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public double magnitudeSquared() {
        return x*x + y*y + z*z;
    }

    public Vector3D scale(double escalar) {
        return new Vector3D(this.x * escalar, this.y * escalar, this.z * escalar);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}


class AlgebraVectorial {

    public static boolean esPerpendicularA(Vector3D a, Vector3D b) {
        double suma = a.add(b).magnitude();
        double resta = a.subtract(b).magnitude();
        return Math.abs(suma - resta) < 1e-9;
    }


    public static boolean esPerpendicularB(Vector3D a, Vector3D b) {
        return Math.abs(a.subtract(b).magnitude() - b.subtract(a).magnitude()) < 1e-9;
    }

    public static boolean esPerpendicularC(Vector3D a, Vector3D b) {
        return Math.abs(a.dot(b)) < 1e-9;
    }

    public static boolean esPerpendicularD(Vector3D a, Vector3D b) {
        double izq = a.add(b).magnitudeSquared();
        double der = a.magnitudeSquared() + b.magnitudeSquared();
        return Math.abs(izq - der) < 1e-9;
    }

    public static boolean esParaleloE(Vector3D a, Vector3D b) {
        if (b.magnitude() == 0) return false;
        double rx = a.getX() / b.getX();
        double ry = a.getY() / b.getY();
        double rz = a.getZ() / b.getZ();
        return (Double.isFinite(rx) && Double.isFinite(ry) && Double.isFinite(rz)) &&
               (Math.abs(rx - ry) < 1e-9 && Math.abs(ry - rz) < 1e-9);
    }

    public static boolean esParaleloF(Vector3D a, Vector3D b) {
        return a.cross(b).magnitude() < 1e-9;
    }

    public static Vector3D proyeccion(Vector3D a, Vector3D b) {
        double coef = a.dot(b) / b.magnitudeSquared();
        return b.scale(coef);
    }

    public static double componente(Vector3D a, Vector3D b) {
        return a.dot(b) / b.magnitude();
    }
}


public class Ejercicio_1 {
    public static void main(String[] args) {
        Vector3D a = new Vector3D(1, 2, 3);
        Vector3D b = new Vector3D(2, 4, 6);

        System.out.println(" a): " + a);
        System.out.println("b): " + b);

        System.out.println("(c): " + AlgebraVectorial.esPerpendicularC(a, b));
        System.out.println("(f): " + AlgebraVectorial.esParaleloF(a, b));

        Vector3D proy = AlgebraVectorial.proyeccion(a, b);
        System.out.println("Proyección de a sobre b: " + proy);

        double comp = AlgebraVectorial.componente(a, b);
        System.out.println("Componente de a en b: " + comp);
    }
}
