/**
 * Clase Libro
 * Atributos:
 * - ID (int) <- ÚNICA PARA CADA LIBRO
 * - Nombre del autor (no es una clase Autor, es solo un String)
 * - Genero <- Vosotros podéis decidir los géneros que estarán disponibles. 
 *   Ejemplo: INFANTIL, CIENCIA_FICCION, AVENTURA...
 * - Disponibilidad <- Indicará si el libro está disponible para ser prestado o no (boolean)
 * 
 * Métodos
 * - marcarComoPrestado
 * - marcarComoDevuelto
 * - toString
 */
public class Usuario {
	private String nombre;
    private String dni;
    
    public Usuario(String nombre, String dni) {
        setDni(dni);
        this.nombre = nombre;
    }
    
    public String getDni() {
		return dni;
	}
    
    public void setDni(String dni) {
    	while (dni.length() != 9) {
    		this.dni = null;
    	}
		this.dni = dni;
	}
    
    @Override
    public String toString() {
        return "Usuario {" +
                "Nombre='" + nombre + '\'' +
                ", DNI='" + dni + '\'' +
                '}';
    }
}
