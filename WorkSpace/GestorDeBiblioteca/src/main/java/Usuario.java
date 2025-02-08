import java.util.Scanner;
public class Usuario {
	private String nombre;
    private String dni;
    public Scanner teclado= new Scanner (System.in);
    
    public Usuario(String nombre, String dni) {
        setDni(dni);
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public String getDni() {
		return dni;
	}
    
    public void setDni(String dni) {
    	while (dni.length() != 9) {
    		System.out.println("La longitud del dni es 9");
    		dni = teclado.next();
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
