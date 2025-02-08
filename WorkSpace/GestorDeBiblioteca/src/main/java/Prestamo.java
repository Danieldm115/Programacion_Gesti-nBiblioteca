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
