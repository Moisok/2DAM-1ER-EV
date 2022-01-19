package Parking2;

import java.util.ArrayList;

//Clase auxiliar
class accesRW {
	
	//ArrayList
	
	ArrayList <Integer> plazasLibres = new ArrayList<Integer>();
	
	ArrayList <Integer> cochesEsperando = new ArrayList<Integer>();
	
	//Contador de plazas
	
	int libres = 10;
	
	//Tiempo de llegada
	
	int llegada;
	
	//Tiempo de aparcar
	
	int aparcar;
	
	//Condiciones
	
	boolean sale = false;
	
	boolean espera = false;
	
	//Matriculas
	
	int matricula;
	
	//random para salir
	
	int matricula2;
	
	//Metodo de aparcar (van llegando los coches)
	
	synchronized void parking () {
	
			try {
				Thread.sleep(llegada=(int)(Math.random()*(60000 - 1000)+1000));
			}catch(InterruptedException e) {
				e.printStackTrace();
				
			}
			
			matricula=(int)(Math.random()*(40 - 1)+1);
			if(libres == 0) {
				try {
					System.out.println("Coche con matricula " + matricula + " esperando: Parking lleno" );
					cochesEsperando.add(matricula);
					sale = true;
					espera = true;	
					notify();
				}catch(Exception e) {
					System.err.println("No se ha podido aparcar, array Lleno (Coche esperando)");
					e.printStackTrace();
				}
			}else {
				if (espera) {			
					try {
						libres--;
						System.out.println("Coche con matricula " + matricula + ": entra al parking. Plazas libres " + libres);	
					}catch(Exception e) {
						System.err.println("No se ha podido obetener la posicion del coche que espera en el array (coche esperando 2)");
						e.printStackTrace();
					}
				
					try {
						Thread.sleep(aparcar=(int)(Math.random()*(30000-1000)+1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					try {
						cochesEsperando.remove(0);
						plazasLibres.add(matricula);
						sale = true;                                                                                                   
						notify();
						
					}catch(Exception e) {
						System.err.println("N0 se ha podido eliminar el coche del array de espera (Coches espera borrar)");
						e.printStackTrace();
					}
					
					if (cochesEsperando.size() <= 0) {
						espera = false;
					}
					
				}else {
					
					try {
						libres--;
						System.out.println("Coche con matricula " + matricula + ": entra al parking. Plazas libres " + libres);
						try {
							
							Thread.sleep(aparcar=(int)(Math.random()*(30000-1000)+1000));
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						plazasLibres.add(matricula);
						sale = true;
						notify();
						
					} catch(Exception e) {
						System.err.println("No se ha podido añadir al array (Coche aparcando)");
						e.printStackTrace();
						
					}	
				}
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
		//Fin de comprobacion de condicion
		
		//Comprobacion de plazas, asigno 20 para que sea mas dificil salir y asi se llene el parking
		
		matricula2 = (int)(Math.random()*(20-1)+1);
		
			if (matricula2 < plazasLibres.size()) {
				try {
					libres++;
					
					System.out.println("Coche con matricula " + plazasLibres.get(matricula2) + ": sale del parking plazas libres " + libres);
					
					plazasLibres.remove(matricula2);
					
					sale=false;
				}catch(Exception e) {
					System.err.println("No ha podido salir del parkin");
					e.printStackTrace();
				}
					
			}else {
				sale=false;
		}
	}
}
