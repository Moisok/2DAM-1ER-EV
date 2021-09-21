package ejercicios_listas;

import java.util.LinkedList;
import java.util.Queue;

//Ejercicio 6 con listas por Moises Sepulveda Segarra

public class Ejercicio6_lista {
	
	public static void main(String[] args) {
		Queue<String> paraules = new LinkedList<>();
		
		//Aniadimos
		paraules.add("Un");
		paraules.add("Dos");
		paraules.add("Tres");
		
		//Eliminamos
		paraules.remove();
		
		//Volvemos a aniadir
		paraules.add("Dos i mig");
		paraules.add("Tres");
		
		
		
		System.out.println(paraules);
	}
}


