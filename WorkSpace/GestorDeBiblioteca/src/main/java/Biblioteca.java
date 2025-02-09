/**
 * Clase Biblioteca
 * 
 * Atributos:
 * - Lista de libros
 * - Lista de ususarios
 * - Lista de préstamos <- Contiene los préstamos que no se han devuelto aun,
 *   los que se devuelvan se borraran de la lista
 *  
 * Metodos:
 * - agregarLibro
 * - agregarUsuario <- OJO, no debe haber 2 usuarios con el mismo DNI
 * - realizarPrestamo <- Un usuario puede tener varios libros prestados, pero
 *   un libro no puede ser prestado a varios usuarios a la vez ¡OJO! solo se
 *   pueden prestar libros que estén en la biblioteca y solo a usuarios
 *   registrados en ella.
 * - devolverLibro <- Al devolver el libro se borra el préstamo de la lista de préstamos
 * - mostrarLibrosDisponibles
 * - mostrarLibrosPorGenero
 * - mostrarLibroPorId
 * - mostrarPrestamosPorUsuario
 * - mostrarPrestamosCaducados
 * - (todos los que ponen “mostrar” solo deben imprimir por pantalla, no tienen que hacer nada más)
 */

import java.time.LocalDate;
import java.util.*;

public class Biblioteca {
	private List<Libro> libros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    
    public void agregarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getDni().equals(usuario.getDni())) {
                System.out.println("El usuario con DNI " + usuario.getDni() + " ya está registrado.");
                return;
            }
        }
        usuarios.add(usuario);
    }
    
    public void realizarPrestamo(Usuario usuario, Libro libro, LocalDate fechaInicio, LocalDate fechaFin) {
        if (!usuarios.contains(usuario) || !libros.contains(libro) || !libro.getDisponibilidad()) {
            System.out.println("Préstamo no permitido.");
            return;
        }
        Prestamo prestamo = new Prestamo(usuario, libro, fechaInicio, fechaFin);
        prestamos.add(prestamo);
        libro.marcarComoPrestado();
    }
    
    public void devolverLibro(Libro libro) {
        prestamos.removeIf(prestamo -> prestamo.toString().contains(libro.toString()));
        libro.marcarComoDevuelto();
    }
    
    public void mostrarLibrosDisponibles() {
        for (Libro libro : libros) {
            if (libro.getDisponibilidad()) {
                System.out.println(libro);
            }
        }
        System.out.print("\n");
    }
    
    public void mostrarLibrosPorGenero(Genero genero) {
        for (Libro libro : libros) {
            if (libro.toString().contains(genero.toString())) {
                System.out.println(libro);
            }
        }
        System.out.print("\n");
    }
    
    public void mostrarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.toString().contains("ID=" + id)) {
                System.out.println(libro);
                return;
            }
        }
        System.out.println("Libro no encontrado.");
        System.out.print("\n");
    }
    
    public void mostrarPrestamosPorUsuario(Usuario usuario) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.toString().contains(usuario.toString())) {
                System.out.println(prestamo);
            }
        }
        System.out.print("\n");
    }
    
    public void mostrarPrestamosCaducados() {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.estaFueraDeFecha()) {
                System.out.println(prestamo);
            }
        }
        System.out.print("\n");
    }
}
