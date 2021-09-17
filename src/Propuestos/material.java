package Propuestos;

public class material {

	protected String codigo;
	
	protected String titulo;
	
	public material (String codigo, String titulo) {
		
		this.codigo = codigo;
		
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String mostrar() {
		return titulo + " " + codigo ; 
	}
	
}
