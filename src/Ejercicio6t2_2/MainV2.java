package Ejercicio6t2_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;





public class MainV2 {
	
	public static void main (String [] aargs) {
		
		//Construimos 
		Scanner teclado = new Scanner(System.in);
		
		//Variables para introducir 
		int numero = 0;
		
		//Pedimos por teclado el numero
		System.out.println ("Introduce un numero");
		numero = teclado.nextInt();
		
		//Si metemos el numero equivocado....
		if (numero > 9 || numero <= 0) {
			System.err.println ("El numero no es correcto");
		}
		else {
			
			System.out.println("Has introducido " + numero + " se generara " + numero + " hilos");
			
			//Construir executor
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numero);
			
			
			//Bucle para el tema de los hilos
			for (int i=1;i<=numero;i++) {
				BuscarNumeroV2 proceso = new BuscarNumeroV2(i);
				executor.submit(proceso);
			}
			executor.shutdown();
		}		
	}

}
