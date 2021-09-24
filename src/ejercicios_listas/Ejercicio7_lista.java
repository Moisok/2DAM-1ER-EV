package ejercicios_listas;

//Operacion polaca inversa 3 4 6 5 - + * 6 + === (3* (4+ (6-5)) +6
//Ejercicio de anotacion polaca inversa (debe de dar 21 como resultado final) 
//Creado por Moises Sepulveda Segarra
// Ver https://programmerclick.com/article/65191665854/
// LIFO (el ultimo que entra por el primero que sale)
import java.util.*;

public class Ejercicio7_lista {

	public static void main (String [] args) {
		
		//Creamos el Stack de integros
		
		Stack<Integer> numeros = new Stack<>();
		
		//Metemos numeros en el Stack
		numeros.add(3);
		numeros.add(4);
		numeros.add(6);
		numeros.add(5);
		numeros.add(6);
		
		//Print de prueba
		for (int i=0;i<5;i++) {
			System.out.println(numeros.get(i));
		}
		
		//Operaciones
		int resultado1 = numeros.get(2) - numeros.get(3);
		int resultado2 = resultado1 + numeros.get(1);
		int resultado3 = numeros.get(0) * resultado2;
		int resultado4 = resultado3 + numeros.get(4);
		
		
		//Hacemos pop 
		numeros.pop();
		numeros.pop();
		numeros.pop();
		numeros.pop();
		numeros.pop();
		
		//Separamos
		System.out.println(" ");
		
		//Aniadimos
		numeros.add(resultado1);
		numeros.add(resultado2);
		numeros.add(resultado3);
		numeros.add(resultado4);
		
		//Hacemos add Insertamos el 1
		System.out.println(numeros);
		
		
		
	}
	
}
