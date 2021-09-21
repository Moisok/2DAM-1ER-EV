package ejercicios_listas;

import java.util.*;

//Primer ejercicio con listas por Moises Sepulveda Segarra

public class Ejercicio5_lista {

	public static void main(String[] args) {
		
			Stack<String> paraules = new Stack<>();
			
			//Aniadimos
			paraules.push("Un");
			paraules.push("Dos");
			paraules.push("Tres");
			paraules.push("Dos i mig"); //Entre "Dos" i "Tres"
			
			//Quitamos los 2 ultimos y corregimos 
			paraules.pop();
			paraules.pop();
			
			paraules.push("Dos i mig");
			paraules.push("Tres");
		
			//Printamos
			for (int i=0;i<4;i++) {
				System.out.println(paraules.get(i));
			}
	
	}
}
