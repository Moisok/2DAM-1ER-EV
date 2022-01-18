package Ejercicio8t3;
import java.util.ArrayList;

public class Ejercicio8_temperaturas {

	public static void main (String[] args) throws InterruptedException {
		
		tiempo temperaturas = new tiempo();
		
		System.out.println("Introduciendo 100 temperaturas...\n");
		for (int i=0;i<100;i++) {
			temperaturas.temp();
		}
		
		for (int j=0;j<10;j++) {
			search bus1 = new search (temperaturas);
			bus1.start();
			bus1.join();
		}
	}
}




