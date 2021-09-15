package Propuestos;

//tercer ejercicio propuesto (repasos de java)
//Moises sepulveda segarra

import java.util.ArrayList;

public class Propuesto3 {
	
	public static void main (String [] args) {
		
		libro libro1 = new libro ("111234", "El quijote", "Cervantes", 567);
		libro libro2 = new libro ("AADFGH", "Harry potter", "Rowling", 256);
		libro libro3 = new libro ("OIUYTG", "El resplandor", "S.King", 325);
		libro libro4 = new libro ("909UYT", "El guardian  entre el centeno", "Willians", 548);
		libro libro5 = new libro ("IUYTGH", "El principito", "Antoine", 567);
		
		usuario Ana = new usuario ("Ana belen","5558745G",18,879);
		usuario Alfonso = new usuario ("Alfonsito","4334567U",23,678);
		usuario copiaAna = new usuario (Ana);
		usuario copiaAlfonso = new usuario (Alfonso);
		
		//Creamos el array
		ArrayList <usuario> usuarios = new ArrayList <usuario>();
		ArrayList <libro> libros = new ArrayList <libro>();
		
		usuarios.add(Ana);
		usuarios.add(Alfonso);
		
		usuarios.add(copiaAlfonso);
		usuarios.add(copiaAna);

		for (usuario usuario : usuarios) {
			System.out.println(usuario.mostrar());
		}
		
	}

}
