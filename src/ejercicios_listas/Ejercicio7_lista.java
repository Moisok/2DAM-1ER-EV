package ejercicios_listas;

//Ejercicio de anotacion polaca inversa (debe de dar 21 como resultado final)
//Creado por Moises Sepulveda Segarra
// Ver https://programmerclick.com/article/65191665854/
// LIFO (el ultimo que entra por el primero que sale)
import java.util.*;

public class Ejercicio7_lista {

	public static void main (String [] args) {
		
		//Variable
		int resultado = 0;
		
		//Creamos el Stack de integros
		
		Stack<Integer> numeros = new Stack<>();
		
		//Metemos numeros en el Stack
		numeros.add(3);
		numeros.add(4);
		numeros.add(6);
		numeros.add(5);
		numeros.add(6);
		
		//Pruebas (no se muy bien como funciona)
		numeros.pop();
		
		resultado = numeros.get(0) + numeros.get(1);
		
		numeros.add(resultado);
		
		//Print de prueba
		for (int i=0;i<5;i++) {
			System.out.println(numeros.get(i));
		}
		
	}
	
}
