package ejercicios_listas;

public class Producto {

	String codigo;
	String descripcion;
	float precio;
	
	public Producto (String codigo, String descripcion, float precio) {
		this.codigo=codigo;
		this.descripcion=descripcion;
		this.precio=precio;
	}
	
	public String mostrar () {
		return codigo + ": " + descripcion + " " + precio;
	}
	
}
