/**
 * Clase LibroTest
 * 
 * Test de las clases:
 * - testMarcarComoPrestado()
 * - testMarcarComoDevuelto()
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LibroTest {

	@Test
	void testMarcarComoPrestado() {
		Libro libro1 = new Libro("El Imperio Final", "Brandon Sanderson", Genero.CIENCIA_FICCION);

        libro1.marcarComoPrestado();

        assertEquals(false, libro1.getDisponibilidad());
	}

	@Test
	void testMarcarComoDevuelto() {
		Libro libro1 = new Libro("El Imperio Final", "Brandon Sanderson", Genero.CIENCIA_FICCION);

        libro1.marcarComoPrestado();

        assertEquals(false, libro1.getDisponibilidad());

        libro1.marcarComoDevuelto();

        assertEquals(true, libro1.getDisponibilidad());
	}

}
