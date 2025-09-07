package Practica2.ejercicios;
class Vector3 {
    private double x, y, z;

    public Vector3() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3 add(Vector3 other) {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3 scalarMultiply(double r) {
        return new Vector3(r * this.x, r * this.y, r * this.z);
    }

    public double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public Vector3 normalize() {
        double mag = this.magnitude();
        if (mag < 1e-6) {
            throw new IllegalArgumentException("No se puede normalizar un vector cero");
        }
        return new Vector3(this.x / mag, this.y / mag, this.z / mag);
    }

    public double dot(Vector3 other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public Vector3 cross(Vector3 other) {
        return new Vector3(
            this.y * other.z - this.z * other.y,
            this.z * other.x - this.x * other.z,
            this.x * other.y - this.y * other.x
        );
    }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

public class Ejercicio_2 {
    public static void main(String[] args) {

        Vector3 a = new Vector3(1, 2, 3);
        Vector3 b = new Vector3(4, 5, 6);

        System.out.println("Vectores de ejemplo:");
        System.out.println("a: " + a);
        System.out.println("b: " + b + "\n");

        Vector3 suma = a.add(b);
        System.out.println("a) Suma a + b: " + suma + "\n");

        Vector3 multEscalar = a.scalarMultiply(2);
        System.out.println("b) Multiplicación escalar 2 * a: " + multEscalar + "\n");

        double longitudA = a.magnitude();
        System.out.println("b) Longitud |a|: " + longitudA + "\n");

        Vector3 normalA;
        try {
            normalA = a.normalize();
            System.out.println("d) Normal de a: " + normalA + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }

        double prodEscalar = a.dot(b);
        System.out.println("e) Producto escalar a · b: " + prodEscalar + "\n");

        Vector3 prodVectorial = a.cross(b);
        System.out.println("f) Producto vectorial a × b: " + prodVectorial + "\n");
    }
}
