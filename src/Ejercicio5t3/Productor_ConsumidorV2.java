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
	
	private boolean lib_cons = false;
	
	private boolean lib_prod = true;
	
	
	synchronized void producir () throws InterruptedException {
		while (!lib_prod) {
			wait();
		}
		if (productos.size()==5) {
			System.out.println("Stock Lleno produccion bloqueada");
			notify();
			lib_prod = false;
			lib_cons = true;
			Thread.sleep(3000);
		}else {
			random = (int)(Math.random()*(50 - 1)+1);
			System.out.println("Productor produce [" + random + "]");
			productos.add(random);
			notify();
			lib_prod = false;
			lib_cons = true;
			Thread.sleep(3000);
		}	
	}
	
	synchronized void consumir () throws InterruptedException {
		while (!lib_cons) {
			wait();
		}
		if (productos.size()==0) {
			System.out.println("Stock vacio, no hay nada que comprar");
			notify();
			lib_prod=true;
			lib_cons=false;
		}else {
				System.out.println("Consumidor consume producto ["+productos.get(productos.size()-1)+"]\n");
				productos.remove(productos.size()-1);
				notify();
				lib_prod=true;
				lib_cons=false;
			}
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
			for (int i=0;i<49;i++) {
				try {
					accesrw.producir();
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
			for (int i=0;i<49;i++) {
				try {
					accesrw.consumir();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}