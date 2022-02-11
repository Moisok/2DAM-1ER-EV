//Moises Sepulveda Segarra
/*KeyboardData.matches("([0-9]+.)+")*/

package Ejercicio1t4;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ejercicio1t4 {

	public static void main(String[] args) {
		
		//Teclado
		Scanner keyboard = new Scanner(System.in);
		
		//Variables
		String KeyboardData= " ";
		
		//Bucle
		while (KeyboardData.contentEquals("exit") == false || KeyboardData.contentEquals("quit") == false) {
			
			System.out.println("Introduce Direccion o ip");
			
			KeyboardData = keyboard.nextLine();
			
			if (Character.isDigit(KeyboardData.charAt(0))) {
				System.out.println(" ");
				try {
					System.out.println("Address: " + InetAddress.getByName(KeyboardData).getHostName());
				} catch (UnknownHostException e) {
					System.err.println("No puede encontrar la direccion o el servidor");
				}
			}
			
			//Condicion para salir
			else if (KeyboardData.equals("exit") || KeyboardData.equals("quit")) {
				
				System.out.println("Finalizando consulta");
			}
			
			else {
				try {
					System.out.println(" ");
					System.out.println("Adress: " + InetAddress.getByName(KeyboardData).getHostAddress());
				} catch (UnknownHostException e) {
					System.err.println("No puede encontrar la direccion o el servidor");
				}
			}
				
		}

		System.out.println("Consulta Finalizada");
	}

}
