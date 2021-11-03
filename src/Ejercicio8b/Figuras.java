package Ejercicio8b;

import java.util.ArrayList;

public class Figuras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creamos las formas y la tabla
		
		Circulo circulo1 = new Circulo (7);
		Cuadrado cuadrado1 = new Cuadrado (6);
		Rectangulo rectangulo1 = new Rectangulo (11,23);
		
		//Creamos la tabla
		Tabla tabla1 = new Tabla();
		
		//Invocamos los metodos de cada figura
		//Primero el circulo
		circulo1.CalcularArea();
		circulo1.CalcularPerimetro();
		
		//Ahora cuadrado
		cuadrado1.CalcularArea();
		cuadrado1.CalcularPerimetro();
		
		//Por ultimo el rectangulo
		rectangulo1.CalcularArea();
		rectangulo1.CalcularPerimetro();
		
		//Ahora lo printeamos todo dentro del arraylist
		ArrayList <IDibujable> dibujos = new ArrayList <IDibujable>();
		
		dibujos.add(tabla1);
		dibujos.add(circulo1);
		dibujos.add(cuadrado1);
		dibujos.add(rectangulo1);
		
		for (IDibujable iDibujable : dibujos) {
			iDibujable.Dibujar();
		}

	}

}
