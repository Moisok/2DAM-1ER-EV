package Propuestos;

import java.util.ArrayList;

public class usuario {
	
	//Artributos
	String nombre;
	String DNI;
	int edad;
	int codigo;
	ArrayList <libro> libros = new ArrayList <libro>();
	
	//Contructor
	public usuario (String nombre, String DNI, int edad, int codigo) {
		
		this.nombre = nombre;
		
		this.DNI = DNI;
		
		this.edad = edad;
		
		this.codigo = codigo;
	}
	
	//Copia de usuario
	public usuario(usuario copia) {
		this.nombre=copia.nombre;
		this.DNI=copia.DNI;
		this.edad=copia.edad;
		this.codigo=copia.codigo;
	}
	
	//Metodo para agregar o quitar libros
	public void agregar (libro x) {
		libros.add(x);
	}
	
	public void quitar (int posicion) {
		if(libros.get(posicion) == null) {
			System.out.println ("No se encuentra el libro");
		}
		libros.remove(posicion);
	}

	//Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	//Mostrar
	public void mostrar() {
		if (libros.isEmpty()) {
		System.out.println (nombre + " " + DNI + " " + edad + " " + codigo +  " ");
		}
		else 
			System.out.println (nombre + " " + DNI + " " + edad + " " + codigo + " ");
			for (libro libro : libros) {
				System.out.println (nombre + " Tiene: " + libro.mostrar());
			}
	
	}
	
	
	
	
	
}
