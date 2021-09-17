package Propuestos;

//Clase pelicula

public class pelicula extends material {
	
	//Artributos

	private String autor;
	
	private String duracion;
	
	private String compania;
	
	//Constructor
	public pelicula (String codigo, String titulo, String autor, String duracion, String compania) {
		
		super (codigo, titulo);
		
		this.autor = autor;
		
		this.duracion = duracion;
		
		this.compania = compania;
		
	}

	//Metodos
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodi (String codigo) {
		if (codigo != null && !codigo.contentEquals("")) {
			
			this.codigo = codigo;
			
		}
	}
	
	@Override
	public String mostrar() {
		return titulo + " " + autor + " " + duracion + " " + codigo + " compania: " + compania + "es pelicula" ; 
	}
	
}