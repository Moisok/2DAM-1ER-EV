package Ejercicio8t3;
import java.util.ArrayList;

public class Ejercicio8_temperaturas {

	public static void main (String[] args) throws InterruptedException {
		
		tiempo temperaturas = new tiempo();
		
		System.out.println("Introduciendo 100 temperaturas...\n");
		for (int i=0;i<100;i++) {
			temperaturas.temp();
		}
		
		//Meterlo en un vector
		// Trobar[] fils = new trobar[nfils];
		//fils[i].start();
		
		search[] hilos = new search[11];
		
		for (int g=0;g<10;g++) {
			hilos[g] = new search(temperaturas);
			hilos[g].start();
 		}
		
		for (int g=0;g<10;g++) {
			hilos[g].join();
 		}
		
		
	}
}




