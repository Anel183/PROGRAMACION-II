package Practica5.ejercicio;

import java.util.ArrayList;
class Pagina {
    public int numero;
    public String contenido;

    public Pagina(int numero, String contenido) {
        this.numero = numero;
        this.contenido = contenido;
    }

    public String toString() {
        return "Pagina " + numero + ": " + contenido;
    }
}

class Horario {
    public String diasApertura;
    public String horaApertura;
    public String horaCierre;

    public Horario(String dias, String apertura, String cierre) {
        this.diasApertura = dias;
        this.horaApertura = apertura;
        this.horaCierre = cierre;
    }

    public String mostrarHorario() {
        return "Días: " + diasApertura + ", " + horaApertura + " - " + horaCierre;
    }

    public String toString() {
        return mostrarHorario();
    }
}


class Libro {
    public String titulo;
    public String isbn;
    public ArrayList<Pagina> paginas;   

    public Libro(String titulo, String isbn, String[] contenidos) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();
        for (int i = 0; i < contenidos.length; i++) {
            this.paginas.add(new Pagina(i + 1, contenidos[i]));
        }
    }

    public String leer() {
        StringBuilder sb = new StringBuilder();
        for (Pagina p : paginas) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    public String toString() {
        return "Libro: " + titulo + ", ISBN: " + isbn;
    }
}


class Autor {
    public String nombre;
    public String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String mostrarInfo() {
        return "Autor: " + nombre + ", Nacionalidad: " + nacionalidad;
    }

    public String toString() {
        return mostrarInfo();
    }
}


class Estudiante {
    public String codigo;
    public String nombre;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String mostrarInfo() {
        return "Estudiante: " + nombre + ", Código: " + codigo;
    }

    public String toString() {
        return mostrarInfo();
    }
}


class Prestamo {
    public String fechaPrestamo;
    public String fechaDevolucion;
    public Estudiante estudiante;   
    public Libro libro;              

    public Prestamo(Estudiante estudiante, Libro libro,
                    String fechaPrestamo, String fechaDevolucion) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String mostrarInfo() {
        return "Préstamo: " + estudiante.nombre + " prestó '" + libro.titulo + "' el " + fechaPrestamo + ", devolución: " + fechaDevolucion;
    }

    public String toString() {
        return mostrarInfo();
    }
}

class Biblioteca {
    public String nombre;
    public ArrayList<Libro> libros;       
    public ArrayList<Autor> autores;       
    public ArrayList<Prestamo> prestamos;  
    public Horario horario;                

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.horario = new Horario("Lunes a Viernes", "08:00", "18:00");
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public void agregarAutor(Autor autor) {
        this.autores.add(autor);
    }

    public void prestarLibro(Estudiante estudiante, Libro libro, String fechaPrestamo, String fechaDevolucion) {
        Prestamo prestamo = new Prestamo(estudiante, libro, fechaPrestamo, fechaDevolucion);
        this.prestamos.add(prestamo);
        this.libros.remove(libro);
    }

    public void mostrarEstado() {
        System.out.println("ESTADO DE LA BIBLIOTECA: " + nombre + "");
        System.out.println("Horario: " + horario);
        System.out.println("Libros disponibles: " + libros);
        System.out.println("Autores registrados: " + autores);
        System.out.println("Préstamos activos: " + prestamos);
        System.out.println("-----------------------------");
    }

    public void cerrarBiblioteca() {
        System.out.println("Cerrando biblioteca " + nombre + ". Todos los préstamos se eliminan.");
        this.prestamos.clear();
    }
}

public class Ejercicio_1 {
    public static void main(String[] args) {

        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiano");
        String[] paginasContenido = {
            "Era inevitable...", "Muchos años después..."
        };
        Libro libro1 = new Libro("Cien Años de Soledad", "978-0307474728", paginasContenido);
        Estudiante estudiante1 = new Estudiante("2023001", "Juan Pérez");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central UMSA");
        biblioteca.agregarAutor(autor1);
        biblioteca.agregarLibro(libro1);
        biblioteca.prestarLibro(estudiante1, libro1, "2025-10-28", "2025-11-11");

        biblioteca.mostrarEstado();
        System.out.println("Horario de la biblioteca: " + biblioteca.horario);
        System.out.println("Leyendo libro:\n" + libro1.leer());
        biblioteca.cerrarBiblioteca();
        biblioteca.mostrarEstado();
    }
}