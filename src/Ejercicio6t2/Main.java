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
			System.out.println("Has introducido " + numero + " se generara " + numero + " filas");
			//Empezamos el programa 
			//En primer lugar creamos los procesos
			BuscarNumero proceso1 = new BuscarNumero (1);
			BuscarNumero proceso2 = new BuscarNumero (2);
			BuscarNumero proceso3 = new BuscarNumero (3);
			BuscarNumero proceso4 = new BuscarNumero (4);
			BuscarNumero proceso5 = new BuscarNumero (5);
			BuscarNumero proceso6 = new BuscarNumero (6);
			BuscarNumero proceso7 = new BuscarNumero (7);
			BuscarNumero proceso8 = new BuscarNumero (8);
			BuscarNumero proceso9 = new BuscarNumero (9);
			
			//Ahora creamos los hilos donde introduciremos los procesos
			Thread hilo1 = new Thread(proceso1);
			Thread hilo2 = new Thread(proceso2);
			Thread hilo3 = new Thread(proceso3);
			Thread hilo4 = new Thread(proceso4);
			Thread hilo5 = new Thread(proceso5);
			Thread hilo6 = new Thread(proceso6);
			Thread hilo7 = new Thread(proceso7);
			Thread hilo8 = new Thread(proceso8);
			Thread hilo9 = new Thread(proceso9);
			
			//Ahora segun la opcion que hemos cogido iniciaremos los hilos con los procesos dentro
			//El .join es para que cuando acabe el proceso empiece el siguiente y asi no se mezclen
			switch(numero) {
			case 1:
				hilo1.start();
				break;
			case 2:
				hilo1.start();
				//hilo1.join();
				hilo2.start();
				break;	
			case 3:
				hilo1.start();
				//hilo1.join();
				hilo2.start();
				//hilo2.join();
				hilo3.start();
				break;	
			case 4:
				hilo1.start();
				//hilo1.join();
				hilo2.start();
				//hilo2.join();
				hilo3.start();
				//hilo3.join();
				hilo4.start();
				break;	
			case 5:
				hilo1.start();
				//hilo1.join();
				hilo2.start();
				//hilo2.join();
				hilo3.start();
				//hilo3.join();
				hilo4.start();
				//hilo4.join();
				hilo5.start();
				break;	
			case 6:
				hilo1.start();
				//hilo1.join();
				hilo2.start();
				//hilo2.join();
				hilo3.start();
				//hilo3.join();
				hilo4.start();
				//hilo4.join();
				hilo5.start();
				//hilo5.join();
				hilo6.start();
				break;
			case 7:
				hilo1.start();
				//hilo1.join();
				hilo2.start();
				//hilo2.join();
				hilo3.start();
				//hilo3.join();
				hilo4.start();
				//hilo4.join();
				hilo5.start();
				//hilo5.join();
				hilo6.start();
				//hilo6.join();
				hilo7.start();
				break;	
			case 8:
				hilo1.start();
				//hilo1.join();
				hilo2.start();
				//hilo2.join();
				hilo3.start();
				//hilo3.join();
				hilo4.start();
				//hilo4.join();
				hilo5.start();
				//hilo5.join();
				hilo6.start();
				//hilo6.join();
				hilo7.start();
				//hilo7.join();
				hilo8.start();
				break;	
			case 9:
				hilo1.start();
				//hilo1.join();
				hilo2.start();
				//hilo2.join();
				hilo3.start();
				//hilo3.join();
				hilo4.start();
				//hilo4.join();
				hilo5.start();
				//hilo5.join();
				hilo6.start();
				//hilo6.join();
				hilo7.start();
				//hilo7.join();
				hilo8.start();
				//hilo8.join();
				hilo9.start();
				break;	
			}
			
			
		}

	}

}





