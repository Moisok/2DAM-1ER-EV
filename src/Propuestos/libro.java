package Propuestos;

//Clase Libro

public class libro {
	
	//Artributos
	private String codigo;
	
	private String titulo;
	
	private String autor;
	
	private int numPag;
	
	//Constructor
	public libro (String codigo, String titulo, String autor, int numPag) {
		
		this.codigo = codigo;
		
		this.titulo = titulo;
		
		this.autor = autor;
		
		this.numPag = numPag;
		
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
	
	public String mostrar() {
		return titulo + " " + autor + " " + numPag + " " ; 
	}
	
	

}
