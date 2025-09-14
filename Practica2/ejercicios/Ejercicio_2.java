package Practica2.ejercicios;
class Vector {
    private double x, y, z;

    public Vector() {
        this.x = this.y = this.z = 0;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public Vector add(Vector v) {
        return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public Vector scale(double r) {
        return new Vector(r * this.x, r * this.y, r * this.z);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }
    public Vector normalize() {
        double mag = this.magnitude();
        if (mag == 0) return new Vector(0, 0, 0);
        return new Vector(x / mag, y / mag, z / mag);
    }

    public double dot(Vector v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public Vector cross(Vector v) {
        return new Vector(
            this.y * v.z - this.z * v.y,
            this.z * v.x - this.x * v.z,
            this.x * v.y - this.y * v.x
        );
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

public class Ejercicio_2 {
    public static void main(String[] args) {
        Vector a = new Vector(1, 2, 3);
        Vector b = new Vector(4, -5, 6);

        System.out.println("Vector a = " + a);
        System.out.println("Vector b = " + b);

        System.out.println("a)" + a.add(b));

        System.out.println("b) " + a.scale(2));

        System.out.println("c)" + a.magnitude());

        System.out.println("d)" + a.normalize());

        System.out.println("e) " + a.dot(b));

        System.out.println("f)" + a.cross(b));
    }
}
