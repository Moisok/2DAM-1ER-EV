package Ejercicio8;

//Programa para gestionar figuras geometricas
//Creado por Moises Sepulveda Segarra

import java.util.ArrayList;

public class Ejercicio8_main {

	public static void main(String[] args) {
		
		//Creamos primero los objetos
		
		Circulo circulo1 = new Circulo(5.0);
		Triangulo Triangulo1 = new Triangulo(5.7,4.5);
		Cuadrado cuadrado1 = new Cuadrado(7.0);
		Rectangulo rectangulo1 = new Rectangulo(7,6);
		
		//Creamos Arraylist
		ArrayList <dibujar> formasGeometricas = new ArrayList<dibujar>();
		
		//Añadimos objetos al Array
		formasGeometricas.add(circulo1);
		formasGeometricas.add(Triangulo1);
		formasGeometricas.add(cuadrado1);
		formasGeometricas.add(rectangulo1);
		
		//Calculamos primero usando los metodos
		for (dibujar dibujar : formasGeometricas) {
			dibujar.area();
			dibujar.perimetro();
		}
		
		//Ahora mostramos los datos de cada figura con otro bucle foreach
		for (dibujar dibujar : formasGeometricas) {
			System.out.println(dibujar.imprimir());
		}
		
	}

}
