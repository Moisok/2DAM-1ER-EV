package Ejercicio5t3;

import java.util.ArrayList;

//Clase main
public class Productor_ConsumidorV2 {

	public static void main(String[] args) {
		
		AccesRW accesrw = new AccesRW();
		
		producir produccion = new producir (accesrw);
		
		consumir consumicion = new consumir (accesrw);
		
		produccion.start();
		
		consumicion.start();
		
	}
}


//Clase accesRW
class AccesRW {
	
	int random;
	
	int random2;
	
	ArrayList <Integer> productos = new ArrayList <Integer>(); //Aray de 5
	
	synchronized void producir () throws InterruptedException {
		while  (productos.size() >= 5) {
			wait();
		}
		
		random = (int)(Math.random()*(50 - 1)+1);
		System.out.println("Productor produce [" + random + "]");
		productos.add(random);
		notify();
		
	}
	
	synchronized void consumir () throws InterruptedException {
		while (productos.size() <= 0) {
			wait();
		}
			random2 = (int)(Math.random()*(productos.size() - 0));
			System.out.println("Consumidor consume producto ["+productos.get(random2)+"]\n");
			productos.remove(random2);
			notify();	

		}
	}
	

//Hilo productor
class producir extends Thread {
		AccesRW accesrw;
		//Constructor
		producir (AccesRW accesrw){
			this.accesrw = accesrw;
		}
		//runable
		@Override
		public void run () {
			for (int i=0;i<50;i++) {
				try {
					accesrw.producir();
					Thread.sleep((int)(Math.random()*1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}	
		}
	}

//Hilo consumidor
class consumir extends Thread {
		AccesRW accesrw;
		//Constructor
		consumir (AccesRW accesrw){
			this.accesrw = accesrw;	
		}
		//runable
		@Override
		public void run () {
			for (int i=0;i<50;i++) {
				try {
					accesrw.consumir();	
					Thread.sleep((int)(Math.random()*2000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}