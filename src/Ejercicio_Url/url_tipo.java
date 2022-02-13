package Ejercicio_Url;


import java.io.IOException;
import java.net.*;
import java.util.Scanner;

//Moises Sepulveda Segarra

//El ejercicio consiste en poner una URL (que nos pedira el programa) y que nos diga que tipo es (si es imagen, web ect....)

public class url_tipo {

	public static void main(String[] args) {
		
		//Varaiable
		
		Scanner keyboard = new Scanner(System.in);
					
		String inputKeyboard = " ";
		
			while (inputKeyboard.contains("exit") == false ) {
					
				System.out.println("Introduce enlace");
					
				inputKeyboard = keyboard.nextLine();
				
				try {
				URL direccion = new URL(inputKeyboard);
				
				URLConnection conexion = direccion.openConnection();
	
				System.out.println("Contenido: " + direccion.getFile().lastIndexOf(1));

				}catch(IOException e) {
					
					System.out.println("No se ha podido obtener la informacion del tipo de contenido");
					e.printStackTrace();
					
			}		
		}				
	}

}

