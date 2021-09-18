package Datos_persona;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int aleatorio;
		//Genera el numero
			aleatorio = (int)(1 + (Math.random() * 99999999));
		//Calcula la letra
			String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";

			int modulo= aleatorio % 23;

			char letra = juegoCaracteres.charAt(modulo);
			
			System.out.println ("El DNI es: " + aleatorio+letra);

	}

}
