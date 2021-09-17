package Propuestos;

//Clase Libro

public class libro extends material {
	
	//Artributos

	private String autor;
	
	private int numPag;
	
	//Constructor
	public libro (String codigo, String titulo, String autor, int numPag) {
		
		super (codigo, titulo);
		
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
	
	@Override
	public String mostrar() {
		return titulo + " " + autor + " " + numPag + " " + codigo + " es libro" ; 
	}
	
	

}
