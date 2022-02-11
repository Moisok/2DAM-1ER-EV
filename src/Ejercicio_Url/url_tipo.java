package Ejercicio_Url;

import java.net.*;

import java.util.Scanner;

//Moises Sepulveda Segarra

//El ejercicio consiste en poner una URL (que nos pedira el programa) y que nos diga que tipo es (si es imagen, web ect....)

public class url_tipo {

	public static void main(String[] args) {
		
		//Construccion de la entrada de datos
		Scanner keyboard= new Scanner(System.in);
		
		//Varaiable
		String inputKeyboard = " ";
		
		while (inputKeyboard.contains("exit") == false ) {
			
			System.out.println("Introduce enlace");
			
			inputKeyboard = keyboard.nextLine();
			
			
			
		}

	}

}
