package ejercicios_listas;

//Operacion polaca inversa 3 4 6 5 - + * 6 + === (3* (4+ (6-5)) +6
//Ejercicio de anotacion polaca inversa (debe de dar 21 como resultado final) 
//Creado por Moises Sepulveda Segarra
// Ver https://programmerclick.com/article/65191665854/
// LIFO (el ultimo que entra por el primero que sale)
import java.util.*;
import java.util.Scanner;

public class Ejercicio7_lista {

	public static void main (String [] args) {
		//Creamos el Stack de integros
		Stack<Integer> numeros = new Stack<>();
		
		//Creamos el array para las operaciones
		String [] operaciones  = new String [4];
		
		//operaciones
		int operacion1 = 0;
		int operacion2 = 0;
		int operacion3 = 0;
		int operacion4 = 0;
		
		//Metemos numeros en el Stack
		numeros.add(3);
		numeros.add(4);
		numeros.add(6);
		numeros.add(5);
		numeros.add(6);
		
		//Introducimos las operaciones
		operaciones[0]= "-";
		operaciones[1]= "+";
		operaciones[2]= "*";
		operaciones[3]= "+";
		
		//Printeamos primeros resultados
		System.out.println(numeros);
		
		//Operaciones
		for (int i=0; i<operaciones.length;i++) {
			if (operaciones[i].equals("-")) {
				operacion1 = numeros.get(4) - numeros.get(3);
				//Eliminamos las posiciones 4 y 3 y metemos el resultado de operacion1 que es 1
				numeros.pop();
				numeros.add(operacion1);
				//Ahora el 1 esta en la posicion numeros.get(4);
				
			}
			if (operaciones[i].equals("+") && i == 1) {
				//Ahora sumamos la posicion 1 que vale 4 mas la posicion 3 que vale 1
				operacion2 = numeros.get(1) + numeros.get(4);
				//Eliminamos las posiciones 2 y 3 y metemos el resultado de operacion 2 que es 5
				numeros.pop();
				numeros.add(operacion2);
				//Ahora el 5 esta en la posicion 3 numeros.get(3);
				
			}
			if (operaciones[i].equals("*") && i == 2) {
				//Ahora multiplicamos la posicion 0 que vale 3 por la posicion 2 que vale 5
				operacion3 = numeros.get(0) * numeros.get(3);
				numeros.pop();//2
				numeros.add(operacion3);//1;
				//Deberia vale 15
				
			}
			if (operaciones[i].equals("+") && i == 3) {
				operacion4 = numeros.get(4) + numeros.get(2);
				numeros.pop();
				numeros.add(operacion4);
				//Resultado final 21
				
			}
		}
		
		//Obtenemos resultados
		System.out.println(numeros);
	}
	
}
