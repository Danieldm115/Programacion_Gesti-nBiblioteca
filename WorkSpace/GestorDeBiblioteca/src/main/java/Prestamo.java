/**
 * Clase Prestamo
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
 *   está entre la fecha de inicio y la de fin), y false en caso contrario
 * - toString
 */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
	private Usuario usuario;
    private Libro libro;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    public Prestamo(Usuario usuario, Libro libro, LocalDate fechaInicio, LocalDate fechaFin) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        
        long diasDiferencia = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        if (diasDiferencia > 30) {
            this.fechaFin = fechaInicio.plusDays(30);
        } else if (diasDiferencia < 0) {
            this.fechaFin = fechaInicio.plusDays(15);
        } else {
            this.fechaFin = fechaFin;
        }
    }
    
    public long obtenerDiasDePrestamo() {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }
    
    public boolean estaFueraDeFecha() {
        LocalDate hoy = LocalDate.now();
        return hoy.isBefore(fechaInicio) || hoy.isAfter(fechaFin);
    }
    
    @Override
    public String toString() {
        return "Prestamo{" +
                "Usuario=" + usuario +
                ", Libro=" + libro +
                ", FechaInicio=" + fechaInicio +
                ", FechaFin=" + fechaFin +
                '}';
    }
}
