package Parking2;

//Creado por moises sepulveda segarra

import java.util.ArrayList;

public class ParkingV2 {
	public static void main (String [] args) {
		
		accesRW accesoParking = new accesRW();
		
		System.out.println("[SIMULACION DE PARKING INICIADA LOS COCHES PUEDEN TARDAR HASTA 1 MINUTO EN LLEGAR]");
		
		for (int i=0;i<40;i++) {
			new parking(accesoParking).start();
		}
	}
}




