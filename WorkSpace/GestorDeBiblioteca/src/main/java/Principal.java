/**
 * Clase Principal
 * 
 * Atributos:
 * - Usuario
 * - Libro
 * - FechaDeInicioDePrestamo <- La fecha de inicio tendrá que ser anterior a la fecha de fin.
 * - FechaDeFinDePrestamo <- Máximo 30 días de préstamo. Si la fecha fin de préstamo tiene más
 *   de 30 días de diferencia con la de inicio, se debe inicializar la fecha de fin con 30 días
 *   después de la de inicio, y si la fecha de fin es ANTERIOR a la de inicio, inicializar la
 *   fecha de fin como la fecha 15 días después de la de inicio.
 *   
 * Métodos:
 * - obtenerDiasDePrestamo
 * - estaFueraDeFecha <- devuelve true si el préstamo está fuera de fecha (la fecha actual no
 *   está entre la fecha de inicio y la de fin), y false en caso contrario.
 * - toString
 */

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.agregarLibro(new Libro("El Imperio Final", "Brandon Sanderson", Genero.CIENCIA_FICCION));
        biblioteca.agregarLibro(new Libro("El Hobbit", "J.R.R. Tolkien", Genero.FANTASIA));
        
        biblioteca.agregarUsuario(new Usuario("Daniel Díaz", "53779194L"));
        
        int opcion;
        do {
            System.out.println("1. Mostrar libros disponibles");
            System.out.println("2. Mostrar libros por género");
            System.out.println("3. Mostrar libro por ID");
            System.out.println("4. Mostrar préstamos caducados");
            System.out.println("5. Salir\n");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); 
            
            switch (opcion) {
                case 1:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 2:
                    System.out.print("Ingrese el género: ");
                    String generoStr = teclado.nextLine().toUpperCase();
                    try {
                        biblioteca.mostrarLibrosPorGenero(Genero.valueOf(generoStr));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Género no válido.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la ID del libro: ");
                    int id = teclado.nextInt();
                    biblioteca.mostrarLibroPorId(id);
                    break;
                case 4:
                    biblioteca.mostrarPrestamosCaducados();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
        teclado.close();
	}

}
