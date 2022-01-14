package Parking2;

//Creado por moises sepulveda segarra

import java.util.ArrayList;

public class ParkingV2 {
	public static void main (String [] args) {
		accesRW accesoParking = new accesRW();
		System.out.println("[SIMULACION DE PARKING INICIADA LOS COCHES PUEDEN TARDAR HASTA 1 MINUTO EN LLEGAR]");
		System.out.println("[SIMULACION DE PARKING INICIADA LOS COCHES PUEDEN TARDAR HASTA 1 MINUTO EN LLEGAR]");
		for (int i=0;i<40;i++) {
			new parking(accesoParking).start();
			//new salirparking(accesoParking).start();
		}
	}
}
//Clase auxiliar
class accesRW {
	//ArrayList
	ArrayList <Integer> plazasLibres = new ArrayList<Integer>();
	//Contador de plazas
	int libres = 10;
	//Tiempo de llegada
	int llegada;
	//Tiempo de aparcar
	int aparcar;
	//Condiciones
	boolean sale = false;;
	//Matriculas
	int matricula;
	//random para salir
	int matricula2;
	//Metodo de aparcar (van llegando los coches)
	synchronized void parking () {
			try {
				llegada=(int)(Math.random()*(60000 - 1000)+1000);
				Thread.sleep(llegada);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			matricula=(int)(Math.random()*(9999 - 1111)+1111);
			if(libres <= 0) {
				System.out.println("Coche con matricula " + matricula + " esperando: Parking lleno" );
				notify();
				sale = true;
			}else {
				libres--;
				System.out.println("Coche con matricula " + matricula + ": entra al parking. Plazas libres " + libres);
				aparcar=(int)(Math.random()*(30000-1000)+1000);
				try {
					Thread.sleep(aparcar);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				plazasLibres.add(matricula);
				notify();
				sale = true;
			}
	}
	//Metodo para salir;
	synchronized void salida_parking () {
		while (!sale) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Fin de comprobacion
		//Comprobacion de plazas, asigno 30 para que sea mas dificil salir y asi se llene el parking
		matricula2 = (int)(Math.random()*(30-1)+1);
			if (matricula2 < plazasLibres.size()) {
				libres++;
				System.out.println("Coche con matricula " + plazasLibres.get(matricula2) + ": sale del parking plazas libres " + libres);
				plazasLibres.remove(matricula2);
				sale=false;
			}else {
				sale=false;
			}
	}
}
//Hilo para aparcar
class parking extends Thread {
	accesRW acceso;
	parking(accesRW acceso){
		this.acceso=acceso;
	}
	@Override
	public void run() {
		acceso.parking();
		acceso.salida_parking();
	}
}
//Hilo para salir
/*class salirparking extends Thread {
	accesRW acceso;
	salirparking(accesRW acceso){
		this.acceso=acceso;
	}
	@Override
	public void run() {
		
	}
}*/
