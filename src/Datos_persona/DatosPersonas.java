package Datos_persona;

//Moises Sepulveda Segarra

import java.util.Scanner;

			int modulo= aleatorio % 23;

	public static void main(String[] args) {
	
		//Construccion de Scaner
		Scanner teclado = new Scanner(System.in);
		
		//Variables principales
		String nombre;
		int edad;
		String sexo;
		int peso;
		int altura;
		String dni = "null";
		
		//Variable de menu
		int opcion;
		
		//Array clase persona
		persona [] personas = new persona [4];
		
		//Empezamos a pedir datos y a crear 4 personas (en bucle de 4)
			//Primera persona
			System.out.println("Introduce nombre: ");
			nombre= teclado.next();
			System.out.println("Introduce edad: ");
			edad = teclado.nextInt();
			System.out.println("Introduce Sexo (introduce hombre o mujer): ");
			sexo = teclado.next();
			System.out.println("Introduce peso: ");
			peso = teclado.nextInt();
			System.out.println("Introduce altura: ");
			altura = teclado.nextInt();
			persona persona1 = new persona (nombre,edad,dni,sexo,peso,altura);
		
			//Segunda persona
			System.out.println("Introduce nombre: ");
			nombre= teclado.next();
			System.out.println("Introduce edad: ");
			edad = teclado.nextInt();
			System.out.println("Introduce Sexo (introduce hombre o mujer): ");
			sexo = teclado.next();
			System.out.println("Introduce peso: ");
			peso = teclado.nextInt();
			System.out.println("Introduce altura: ");
			altura = teclado.nextInt();
			persona persona2 = new persona (nombre,edad,dni,sexo,peso,altura);
			
			//Tercera persona
			System.out.println("Introduce nombre: ");
			nombre= teclado.next();
			System.out.println("Introduce edad: ");
			edad = teclado.nextInt();
			System.out.println("Introduce Sexo (introduce hombre o mujer): ");
			sexo = teclado.next();
			System.out.println("Introduce peso: ");
			peso = teclado.nextInt();
			System.out.println("Introduce altura: ");
			altura = teclado.nextInt();
			persona persona3 = new persona (nombre,edad,dni,sexo,peso,altura);
			
			//Cuarta persona
			System.out.println("Introduce nombre: ");
			nombre= teclado.next();
			System.out.println("Introduce edad: ");
			edad = teclado.nextInt();
			System.out.println("Introduce Sexo (introduce hombre o mujer): ");
			sexo = teclado.next();
			System.out.println("Introduce peso: ");
			peso = teclado.nextInt();
			System.out.println("Introduce altura: ");
			altura = teclado.nextInt();
			persona persona4 = new persona (nombre,edad,dni,sexo,peso,altura);
		
			//Invocar funcion para calcular IMC
			CalculaIMC(persona1, persona2, persona3, persona4);
			
			//Mostramos si es mayor o no de edad
			System.out.println ("�Es mayor de edad? " + persona1.EsMayorDeEdad());
			System.out.println ("�Es mayor de edad? " + persona2.EsMayorDeEdad());
			System.out.println ("�Es mayor de edad? " + persona3.EsMayorDeEdad());
			System.out.println ("�Es mayor de edad? " + persona4.EsMayorDeEdad());
			
			//Generamos los DNI
			persona1.generarDNI();
			persona2.generarDNI();
			persona3.generarDNI();
			persona4.generarDNI();
			
			//Agregamos al array
			personas[0]=persona1;
			personas[1]=persona2;
			personas[2]=persona3;
			personas[3]=persona4;
			
			//Mostramos toda la info
			for (persona persona : personas) {
				System.out.println (persona.toString());
			}
		
	}
	
	//Funcion para calcular el IMC
	private static void CalculaIMC(persona persona1, persona persona2, persona persona3, persona persona4) {
		//Mostramos primero si esta en el peso (terminar)
		//Persona1 info
		if (persona1.imc() == -1) {
			System.out.println(persona1.getNombre() + " Esta en su peso ideal");
		}
		if (persona1.imc() == 0) {
			System.out.println(persona1.getNombre() + " Esta por debajo de su peso");
		}
		if (persona1.imc() == 1) {
			System.out.println(persona1.getNombre() + " Tiene sobrepeso");
		}
		
		//Persona2 info
		if (persona2.imc() == -1) {
			System.out.println(persona2.getNombre() + " Esta en su peso ideal");
		}
		if (persona2.imc() == 0) {
			System.out.println(persona2.getNombre() + " Esta por debajo de su peso");
		}
		if (persona2.imc() == 1) {
			System.out.println(persona2.getNombre() + " Tiene sobrepeso");
		}
		
		//Persona3 info
		if (persona3.imc() == -1) {
			System.out.println(persona3.getNombre() + " Esta en su peso ideal");
		}
		if (persona3.imc() == 0) {
			System.out.println(persona3.getNombre() + " Esta por debajo de su peso");
		}
		if (persona3.imc() == 1) {
			System.out.println(persona3.getNombre() + " Tiene sobrepeso");
		}
		
		//Persona4 info
		if (persona4.imc() == -1) {
			System.out.println(persona4.getNombre() + " Esta en su peso ideal");
		}
		if (persona4.imc() == 0) {
			System.out.println(persona4.getNombre() + " Esta por debajo de su peso");
		}
		if (persona4.imc() == 1) {
			System.out.println(persona4.getNombre() + " Tiene sobrepeso");
		}
	}
}
