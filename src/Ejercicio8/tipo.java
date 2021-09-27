package Ejercicio8;

//Clase para poner el tipo de figura que es

abstract class tipo {

	String nombre;
	
	public tipo (String nombre) {
		this.nombre = nombre;
	}
	
	//Metodo abtracto
	public abstract void perimetro();
	public abstract void area();
	public abstract void escalar();
	public abstract void imprimir();
	
}
