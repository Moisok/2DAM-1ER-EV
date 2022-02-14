package Ejercicio_Url;


import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.sql.Date;
import java.util.Scanner;

//Moises Sepulveda Segarra

//El ejercicio consiste en poner una URL (que nos pedira el programa) y que nos diga que tipo es (si es imagen, web ect....)

public class url_tipo {

	public static void main(String[] args) {
		
		//Varaiable
		
		Scanner keyboard = new Scanner(System.in);
					
		String inputKeyboard = " ";
		
		InputStream input;
		
		long d;
		
			while (inputKeyboard.contains("exit") == false ) {
					
				System.out.println("Introduce enlace");
					
				inputKeyboard = keyboard.nextLine();
				
				try {
				URL direccion = new URL(inputKeyboard);
				
				URLConnection conexion = direccion.openConnection();
				
				input = conexion.getInputStream();
	
				System.out.println("\nInformacion sobre: " + conexion.getURL());
				System.out.println("Contenido: " + conexion.getContentType());
				if (conexion.getContentType().contains("image")) {
					System.out.println("Tamaño imagen: " + conexion.getContentLength()/1024/1024 + " Mb");
				}
				else if (!conexion.getContentType().contains("image") && !conexion.getContentType().contains("text")) {
					System.out.println("Tamaño: " + conexion.getContentLength()/1024 + " Mb");
					d = conexion.getDate();
					System.out.println("Ultima modificacion: " + new Date(d));
				}
				

				}catch(IOException e) {
					
					System.out.println("\nNo se ha podido obtener la informacion del tipo de contenido");
					
			}		
		}				
	}

}

