package Ejercicio9;

import java.util.*;

public class MainFiguras {

	
	public static void main(String[] args) {
		//Creamos los arrays y aniadimos criterio a ordenar Area (al que yo he llamado lado)
		
		//Circulos
		Circulo circulo1 = new Circulo (5);
		Circulo circulo2 = new Circulo (7);
		Circulo circulo3 = new Circulo (8);
		
		//Cuadrados
		Cuadrado cuadrado1 = new Cuadrado (87);
		Cuadrado cuadrado2 = new Cuadrado (1);
		Cuadrado cuadrado3 = new Cuadrado (75);
		
		//Rectangulos
		Rectangulo rectangulo1 = new Rectangulo (34,90);
		Rectangulo rectangulo2 = new Rectangulo (89,52);
		Rectangulo rectangulo3 = new Rectangulo (7,9);
				
		//Creamos los arraylist 
		ArrayList <Circulo> circulos = new ArrayList<>();
		ArrayList <Cuadrado> cuadrados = new ArrayList<>();
		ArrayList <Rectangulo> rectangulos = new ArrayList<>();
		
		//A�adimos los circulos al Array
		circulos.add(circulo1);
		circulos.add(circulo2);
		circulos.add(circulo3);
		
		//A�adimos los cuadrados al arrayList
		cuadrados.add(cuadrado1);
		cuadrados.add(cuadrado2);
		cuadrados.add(cuadrado3);
		
		//Por ultimo los rectangulos
		rectangulos.add(rectangulo1);
		rectangulos.add(rectangulo2);
		rectangulos.add(rectangulo3);
			
		//Ordenamos 
		Collections.sort(circulos);
		Collections.sort(cuadrados);
		Collections.sort(rectangulos);
		
		//Mostramos
		System.out.println("Circulos ");
		for (Circulo circulo : circulos) {
			circulo.Dibujar();
		}
		
		System.out.println(" ");
		System.out.println("Cuadrados ");
		for (Cuadrado cuadrado : cuadrados) {
			cuadrado.Dibujar();
		}
		
		System.out.println(" ");
		System.out.println("Rectangulos ");
		for (Rectangulo rectangulo : rectangulos) {
			rectangulo.Dibujar();
		}

	}

}
