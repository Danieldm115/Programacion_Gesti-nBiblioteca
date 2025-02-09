/**
 * Clase Libro
 * 
 * Atributos:
 * - ID (int) <- ÚNICA PARA CADA LIBRO
 * - Titulo
 * - Nombre del autor (no es una clase Autor, es solo un String)
 * - Genero <- Vosotros podéis decidir los géneros que estarán disponibles.
 *   Ejemplo: INFANTIL, CIENCIA_FICCION, AVENTURA...
 * - Disponibilidad <- Indicará si el libro está disponible para ser prestado
 *   o no (boolean)
 *   
 * Métodos:
 * - marcarComoPrestado
 * - marcarComoDevuelto
 * - toString
 */

public class Libro {
	private static int contadorLibros = 1;
    private int id;
    private String titulo;
    private String autor;
    private Genero genero;
    private boolean disponibilidad;
    
	
	public Libro(String titulo, String autor, Genero genero) {
        this.id = contadorLibros++;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponibilidad = true;
    }
	
	public Genero getGenero() {
		return genero;
	}
	
	public boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void marcarComoPrestado() {
        if (disponibilidad) {
            disponibilidad = false;
            System.out.println("El libro ha sido prestado.");
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    public void marcarComoDevuelto() {
        disponibilidad = true;
        System.out.println("El libro ha sido devuelto y está disponible.");
    }

    @Override
    public String toString() {
        return "" + id +
                ", Titulo=' " + titulo + '\'' +
                ", Autor=' " + autor + '\'' +
                ", Genero= " + genero +
                ", Disponible= " + (disponibilidad ? "Sí" : "No");
    }
	
}
