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
