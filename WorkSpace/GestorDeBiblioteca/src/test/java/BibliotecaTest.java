/**
 * Clase BibliotecaTest
 * 
 * Test de las clases:
 * - testAgregarLibro()
 * - testAgregarUsuario()
 * - testRealizarPrestamo()
 * - testDevolverLibro()
 */

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class BibliotecaTest {

	@Test
	void testAgregarLibro() {
		Biblioteca biblioteca = new Biblioteca();
		
		Libro libro1 = new Libro("El Imperio Final", "Brandon Sanderson", Genero.CIENCIA_FICCION);
		
		biblioteca.agregarLibro(libro1);
		
		assertEquals(1, biblioteca.getLibros().size());
	}

	@Test
    void testAgregarUsuario() {
         Biblioteca biblioteca = new Biblioteca();

         Usuario usuario1 = new Usuario("Daniel Díaz", "53779194L");
         biblioteca.agregarUsuario(usuario1);

         assertEquals(1, biblioteca.getUsuarios().size());
    }

    @Test
    void testRealizarPrestamo() {
         Biblioteca biblioteca = new Biblioteca();

         Libro libro1 = new Libro("El Imperio Final", "Brandon Sanderson", Genero.CIENCIA_FICCION);
         biblioteca.agregarLibro(libro1);

         Usuario usuario1 = new Usuario("Daniel Díaz", "53779194L");
         biblioteca.agregarUsuario(usuario1);

         biblioteca.realizarPrestamo(usuario1, libro1, LocalDate.now(), LocalDate.now().plusDays(10));

         assertEquals(1, biblioteca.getPrestamos().size());

    }

    @Test
    void testDevolverLibro() {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("El Imperio Final", "Brandon Sanderson", Genero.CIENCIA_FICCION);
        biblioteca.agregarLibro(libro1);

        Usuario usuario1 = new Usuario("Daniel Díaz", "53779194L");;
        biblioteca.agregarUsuario(usuario1);

        biblioteca.realizarPrestamo(usuario1, libro1, LocalDate.now(), LocalDate.now().plusDays(10));

        assertEquals(1, biblioteca.getPrestamos().size());

        biblioteca.devolverLibro(libro1);

        assertEquals(0, biblioteca.getPrestamos().size());
    }


}
