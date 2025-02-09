import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PrestamoTest {

	@Test
	void testObtenerDiasDePrestamo() {
		Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("El Imperio Final", "Brandon Sanderson", Genero.CIENCIA_FICCION);
        Usuario usuario1 = new Usuario("53779194L", "Daniel Diaz");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarUsuario(usuario1);

        LocalDate inicio = LocalDate.now();
        LocalDate fin = inicio.plusDays(20);
        Prestamo prestamo = new Prestamo(usuario1, libro1, inicio, fin);
        assertEquals(20, prestamo.obtenerDiasDePrestamo());
	}

	@Test
	void testEstaFueraDeFecha() {
		Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("El Imperio Final", "Brandon Sanderson", Genero.CIENCIA_FICCION);
        Usuario usuario1 = new Usuario("53779194L", "Daniel Diaz");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarUsuario(usuario1);

        LocalDate inicio = LocalDate.now().minusDays(30);
        LocalDate fin = inicio.plusDays(20);
        Prestamo prestamo = new Prestamo(usuario1, libro1, inicio, fin);
        assertEquals(true, prestamo.estaFueraDeFecha());
	}

}
