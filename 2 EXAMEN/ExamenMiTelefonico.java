import java.util.ArrayList;

class Persona {
    private final String nombre;
    private final int edad;
    private final float peso;

    public Persona(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public float getPeso() { return peso; }

    @Override
    public String toString() {
        return nombre + " (Edad: " + edad + ", Peso: " + peso + " kg)";
    }
}

class Cabina {
    private final int nroCabina;
    private final Persona[] personasAbordo;
    private int cantidadPersonas;
    private static final int MAX_PERSONAS = 10;
    private static final float MAX_PESO = 850f; 

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new Persona[MAX_PERSONAS];
        this.cantidadPersonas = 0;
    }

    public boolean agregarPersona(Persona p) {
        if (cantidadPersonas >= MAX_PERSONAS) {
            System.out.println("ERROR: Cabina " + nroCabina + " llena");
            return false;
        }
        if (obtenerPesoTotal() + p.getPeso() > MAX_PESO) {
            System.out.println("ERROR: " + p.getNombre() + " excede peso máximo");
            return false;
        }
        personasAbordo[cantidadPersonas++] = p;
        System.out.println(p.getNombre() + " agregado a cabina " + nroCabina);
        return true;
    }

    public float obtenerPesoTotal() {
        float total = 0f;
        for (int i = 0; i < cantidadPersonas; i++) {
            total += personasAbordo[i].getPeso();
        }
        return total;
    }

    public int getCantidadPersonas() { return cantidadPersonas; }
    public Persona getPersona(int i) { return personasAbordo[i]; }

    @Override
    public String toString() {
        String info = "Cabina " + nroCabina + " Personas: " + cantidadPersonas +" Peso total: " + String.format("%.2f", obtenerPesoTotal()) + " kg\n";
        for (int i = 0; i < cantidadPersonas; i++) {
            info += "   → " + personasAbordo[i] + "\n";
        }
        return info;
    }
}

class Linea {
    private final String color;
    private final String nombre;
    private final Persona cabinaPersonal;
    private final ArrayList<Cabina> cabinas;

    public Linea(String color, String nombre, Persona cabinaPersonal) {
        this.color = color;
        this.nombre = nombre;
        this.cabinaPersonal = cabinaPersonal;
        this.cabinas = new ArrayList<>();
    }

    public void agregarCabina(Cabina c) {
        cabinas.add(c);
    }

    public void agregarPrimeraPersonaACabina(int nroCabina, Persona p) {
        if (nroCabina < 1 || nroCabina > cabinas.size()) {
            System.out.println("ERROR: Cabina " + nroCabina + " no existe");
            return;
        }
        cabinas.get(nroCabina - 1).agregarPersona(p);
    }

    public double calcularIngresoTotal(boolean soloRegular) {
        double total = 0;
        for (Cabina c : cabinas) {
            for (int i = 0; i < c.getCantidadPersonas(); i++) {
                Persona p = c.getPersona(i);
                if (soloRegular) {
                    total += 3;
                } else {
                    total += (p.getEdad() < 25 || p.getEdad() > 60) ? 1.5 : 3;
                }
            }
        }
        return total;
    }

    public void mostrar(boolean soloRegular) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("LÍNEA " + nombre.toUpperCase() + " - Color: " + color);
        System.out.println("Personal: " + cabinaPersonal.getNombre());
        System.out.println("Ingreso total " + 
            (soloRegular ? "(regular)" : "(preferencial)") +
            ": Bs. " + String.format("%.2f", calcularIngresoTotal(soloRegular)));
        System.out.println("=".repeat(70));
        for (Cabina c : cabinas) System.out.print(c);
        System.out.println("=".repeat(70));
    }
}

public class ExamenMiTelefonico {
    private final ArrayList<Linea> lineas = new ArrayList<>();

    public static void main(String[] args) {
        ExamenMiTelefonico sistema = new ExamenMiTelefonico();

        Persona pVerde = new Persona("Juan Pérez", 38, 82);
        Persona pRojo = new Persona("María López", 42, 68);

        Linea lineaVerde = new Linea("Verde", "Línea Verde", pVerde);
        Linea lineaRoja = new Linea("Roja", "Línea Roja", pRojo);

        lineaVerde.agregarCabina(new Cabina(1));
        lineaVerde.agregarCabina(new Cabina(2));
        lineaRoja.agregarCabina(new Cabina(1));

        sistema.lineas.add(lineaVerde);
        sistema.lineas.add(lineaRoja);

        Persona p1 = new Persona("Carlos", 22, 75);
        Persona p2 = new Persona("Ana", 65, 58);
        Persona p3 = new Persona("Luis", 30, 88);
        Persona p4 = new Persona("Sofía", 19, 52);
        Persona p5 = new Persona("Pedro", 72, 90);

        lineaVerde.agregarPrimeraPersonaACabina(1, p1);
        lineaVerde.agregarPrimeraPersonaACabina(1, p2);
        lineaVerde.agregarPrimeraPersonaACabina(1, p3);
        lineaVerde.agregarPrimeraPersonaACabina(2, p4);
        lineaRoja.agregarPrimeraPersonaACabina(1, p5);

        lineaVerde.mostrar(false);
        lineaVerde.mostrar(true);
        lineaRoja.mostrar(false);
    }
}