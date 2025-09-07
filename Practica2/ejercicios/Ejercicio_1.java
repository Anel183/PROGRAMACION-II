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

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.x, y + other.y, z + other.z);
    }

    public Vector3D subtract(Vector3D other) {
        return new Vector3D(x - other.x, y - other.y, z - other.z);
    }

    public double dot(Vector3D other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public Vector3D cross(Vector3D other) {
        return new Vector3D(
            y * other.z - z * other.y,
            z * other.x - x * other.z,
            x * other.y - y * other.x
        );
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3D scalarMultiply(double scalar) {
        return new Vector3D(scalar * x, scalar * y, scalar * z);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

interface VectorChecker {
    boolean check(Vector3D a, Vector3D b);
    String getDescription();
}


class PerpendicularTypeA implements VectorChecker {
    @Override
    public boolean check(Vector3D a, Vector3D b) {
        return Math.abs(a.add(b).magnitude() - a.subtract(b).magnitude()) < 1e-6;
    }

    @Override
    public String getDescription() {
        return "(a)Perpendicular: |a + b| = |a - b|";
    }
}

class PerpendicularTypeB implements VectorChecker {
    @Override
    public boolean check(Vector3D a, Vector3D b) {
        Vector3D b_minus_a = new Vector3D(b.getX() - a.getX(), b.getY() - a.getY(), b.getZ() - a.getZ());
        return Math.abs(a.subtract(b).magnitude() - b_minus_a.magnitude()) < 1e-6;
    }

    @Override
    public String getDescription() {
        return "Perpendicular (b): |a - b| = |b - a";
    }
}

class PerpendicularTypeC implements VectorChecker {
    @Override
    public boolean check(Vector3D a, Vector3D b) {
        return Math.abs(a.dot(b)) < 1e-6;
    }

    @Override
    public String getDescription() {
        return "(c) Perpendicular: a · b = 0";
    }
}

// d) Perpendicular: |a + b|^2 = |a|^2 + |b|^2
class PerpendicularTypeD implements VectorChecker {
    @Override
    public boolean check(Vector3D a, Vector3D b) {
        double magAbSq = a.add(b).magnitude();
        magAbSq *= magAbSq;
        double magASq = a.magnitude();
        magASq *= magASq;
        double magBSq = b.magnitude();
        magBSq *= magBSq;
        return Math.abs(magAbSq - magASq - magBSq) < 1e-6;
    }

    @Override
    public String getDescription() {
        return "(d)Perpendicular: |a + b|^2 = |a|^2 + |b|^2";
    }
}

// e) Paralelo: a = r b (proporciones)
class ParallelTypeE implements VectorChecker {
    @Override
    public boolean check(Vector3D a, Vector3D b) {
        if (a.magnitude() < 1e-6 || b.magnitude() < 1e-6) {
            return true; // Vector cero es paralelo a todo
        }
        if (b.getX() != 0) {
            double r = a.getX() / b.getX();
            return Math.abs(a.getY() - r * b.getY()) < 1e-6 && Math.abs(a.getZ() - r * b.getZ()) < 1e-6;
        } else if (b.getY() != 0) {
            double r = a.getY() / b.getY();
            return Math.abs(a.getX() - r * b.getX()) < 1e-6 && Math.abs(a.getZ() - r * b.getZ()) < 1e-6;
        } else if (b.getZ() != 0) {
            double r = a.getZ() / b.getZ();
            return Math.abs(a.getX() - r * b.getX()) < 1e-6 && Math.abs(a.getY() - r * b.getY()) < 1e-6;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "(e)Paralelo: a = r b";
    }
}

// f) Paralelo: a × b = 0
class ParallelTypeF implements VectorChecker {
    @Override
    public boolean check(Vector3D a, Vector3D b) {
        return a.cross(b).magnitude() < 1e-6;
    }

    @Override
    public String getDescription() {
        return "Paralelo (f): a × b = 0";
    }
}

public class Ejercicio_1 {
    public static Vector3D proyeccionDeASobreB(Vector3D a, Vector3D b) {
        double magB = b.magnitude();
        if (magB < 1e-6) {
            throw new IllegalArgumentException("");
        }
        double scalar = a.dot(b) / (magB * magB);
        return b.scalarMultiply(scalar);
    }
    public static double componenteDeAEnB(Vector3D a, Vector3D b) {
        double magB = b.magnitude();
        if (magB < 1e-6) {
            throw new IllegalArgumentException("");
        }
        return a.dot(b) / magB;
    }

    public static void main(String[] args) {
        Vector3D a = new Vector3D(1, 2, 3);
        Vector3D b = new Vector3D(4, 5, 6); 
        Vector3D c = new Vector3D(2, 4, 6);

        VectorChecker[] checkers = {
            new PerpendicularTypeA(),
            new PerpendicularTypeB(),
            new PerpendicularTypeC(),
            new PerpendicularTypeD(),
            new ParallelTypeE(),
            new ParallelTypeF()
        };

        System.out.println("Revision para a y b:");
        for (VectorChecker checker : checkers) { 
            System.out.println(checker.getDescription() + ": " + checker.check(a, b));
        }

        System.out.println("\nRevision para a y c:");
        for (VectorChecker checker : checkers) {
            System.out.println(checker.getDescription() + ": " + checker.check(a, c));
        }

        System.out.println("\n(g)Proyección de a sobre b: " + proyeccionDeASobreB(a, b));
        System.out.println("(h)Componente de a en dirección de b: " + componenteDeAEnB(a, b));
    }
}
