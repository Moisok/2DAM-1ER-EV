package Parking2;

import java.util.ArrayList;

//Clase auxiliar
class accesRW {
	
	//ArrayList
	
	//ArrayList <Integer> plazasLibres = new ArrayList<Integer>();
	
	//ArrayList <Integer> cochesEsperando = new ArrayList<Integer>();
	
	//Contador de plazas
	
	int libres = 10;
	
	//Tiempo de llegada
	
	//Condiciones
	
	boolean sale = false;
	
	boolean espera = false;
	
	//Matriculas
	
	int matricula;
	
	//random para salir
	
	//Metodo de aparcar (van llegando los coches)
	
	synchronized void parking () {
			matricula=(int)(Math.random()*(40 - 1)+1);
			if(libres == 0) {
				try {
					System.out.println("Coche con matricula " + matricula + " esperando: Parking lleno" );
					wait();
					sale = true;
					espera = true;	
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				if (espera) {			
						libres--;
						System.out.println("Coche con matricula " + matricula + ": entra al parking. Plazas libres " + libres);	
						sale = true;                                                                                                   
						notify();
					if (libres == 0) {
						espera = false;
					}
					
				}else {
						libres--;
						System.out.println("Coche con matricula " + matricula + ": entra al parking. Plazas libres " + libres);
						sale = true;
						notify();		
			}
		}
	}
	
	//Metodo para salir;
	synchronized void salida_parking () {
		//Comprobacion de plazas, asigno 20 para que sea mas dificil salir y asi se llene el parking
			if (libres == 0) {
					libres++;				
					System.out.println("Coche con matricula " + matricula + ": sale del parking plazas libres " + libres);
					sale=false;
					
			}else {
				sale=false;
		}
	}
}
