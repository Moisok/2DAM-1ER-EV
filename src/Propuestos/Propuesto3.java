package Propuestos;

//tercer ejercicio propuesto (repasos de java)
//Moises sepulveda segarra

import java.util.ArrayList;
import java.util.Scanner;
public class Propuesto3 {
	
	public static void main (String [] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int posicion;
		
		//Libros
		libro libro1 = new libro ("111234", "El quijote", "Cervantes", 567);
		libro libro2 = new libro ("AADFGH", "Harry potter", "Rowling", 256);
		
		//Peliculas
		pelicula pelicula1 = new pelicula ("FFHHGG", "Jurassic park", "Bruce willis", "120h", "Warner bros" );
		pelicula pelicula2 = new pelicula ("FFHHGG", "La vida de brian", "Michael Scot", "160h", "SOny pictures" );
		
		//Usarios
		usuario Ana = new usuario ("Ana belen","5558745G",18,879);
		usuario Alfonso = new usuario ("Alfonsito","4334567U",23,678);
		
		//Copia de usuarios
		usuario copiaAna = new usuario (Ana);
		usuario copiaAlfonso = new usuario (Alfonso);
		
		//Creamos el array
		ArrayList <usuario> usuarios = new ArrayList <usuario>();
		ArrayList <material> material = new ArrayList <material>();
		
		//Añadimos peliculas y libros 
		usuarios.add(Ana);
		usuarios.add(Alfonso);
		
		//Añadimos las peliculas y los libros a los usuarios
		Ana.agregar(libro1);
		Ana.agregar(pelicula1);
		
		Alfonso.agregar(libro2);
		Alfonso.agregar(pelicula2);

		for (usuario usuario : usuarios) {
			usuario.mostrar();
		}

		System.out.println ("Que material quieres quitar");
		posicion = teclado.nextInt();
		
		Alfonso.quitar(posicion);
		Ana.quitar(posicion);
		
		for (usuario usuario : usuarios) {
			usuario.mostrar();
		}
	}
}
	