package Ejercicio6t2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		//Contruimos Scanner
		Scanner teclado = new Scanner(System.in);
		
		//Variables para introducir
		int numero = 0;
		
		//Pedimos por teclado
		System.out.println("Introduce un numero del 1 al 9");
		numero = teclado.nextInt();
		
		if (numero > 9 || numero <= 0) {
			System.err.println ("El numero no es correcto");
		}
		
		else {
			System.out.println("Has introducido " + numero + " se generara " + numero + " hilos");
			//Bucle para el tema de los hilos
			for (int i=1;i<=numero;i++) {
				BuscarNumero proceso = new BuscarNumero(i);
				Thread hilo = new Thread(proceso);
				hilo.start();
				//Con el join ordenamos, es decir hasta que no acaba el primer hilo no sigue con el siguiente
				//hilo.join();
			}

		}	
			
	}

}







