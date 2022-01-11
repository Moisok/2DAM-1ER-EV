package Ejercicio5t3;

import java.util.ArrayList;

//Clase main
public class Productor_ConsumidorV2 {

	public static void main(String[] args) {
		
		AccesRW accesrw = new AccesRW();
		
		for (int i=0;i<49;i++) {
			new producir(accesrw,i).start();
			new consumir(accesrw,i).start();
		}
	}
}


//Clase accesRW
class AccesRW {
	
	ArrayList <String> elementos = new ArrayList <String>(); //Aray de 5
	
	private int aleatorio;
	
	private boolean liberar = false;
	
	private boolean blo_prod = true;
	
	
	
	String productor;
	
	String consumidor;
	
	//Productor
	public synchronized void producir (int posicion) {
		
		//Como sin 5 elementos cuando esta lleno
		if (elementos.size() == 5 ) {
			blo_prod = false;
			System.out.println("Limpiando Array");
			elementos.clear();
			if (blo_prod == false) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Array vaciado \n");
				blo_prod = true;
			}
			
		}
		
		else {
			
		while (blo_prod) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			aleatorio = (int)(Math.random()*(50 - 1)+1);
			
			System.out.println("Productor produce objeto: " + aleatorio);
			
			productor = "producto " + aleatorio;	
			
			elementos.add(productor);
			
			notify();
			
			liberar = true;
			
			blo_prod = false;
			
			}	
		}	
	}

		

	//Consumidor
	public synchronized void consumir (int posicion) {
		
		if (elementos.isEmpty()) {
			System.out.println("Array Vacio \n");
			blo_prod = true;
			
		}
		
		else {
			while (!liberar) {	
				try {
					wait();
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();	
				}
			}
						aleatorio = (int)(Math.random()*(4 - 1)+1);
					
						if (aleatorio == elementos.size()-1) {
							
							System.out.println("Consumidor consume " + elementos.get(aleatorio) + "\n");
						
							elementos.remove(aleatorio);
						
							liberar = false;
							
							blo_prod = true;	
							
						}else {
							liberar = false;
							
							blo_prod = true;	
						}		
		}
		
	}
}
	
	
//Hilo productor
class producir extends Thread {
		
		AccesRW accesrw;
		
		int posicion;
		
		//Constructor
		producir (AccesRW accesrw, int posicion){
			
			this.accesrw = accesrw;
			
			this.posicion = posicion;
		}
		
		//runable
		@Override
		public void run () {
			accesrw.producir(posicion);
		}
		
	}

//Hilo consumidor
class consumir extends Thread {
		
		AccesRW accesrw;
		
		int posicion;
		
		//Constructor
		consumir (AccesRW accesrw, int posicion){
			
			this.accesrw = accesrw;
			
			this.posicion = posicion;
		}
		
		//runable
		@Override
		public void run () {
			accesrw.consumir(posicion);
		}
	}