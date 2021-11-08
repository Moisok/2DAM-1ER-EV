package Ejercicio7t2;

import java.util.concurrent.Semaphore;

public class CajeroAutomatico {
	
	public static void main (String [] args) {
		
			int sueldo = 1800;
		
			Operacion operaciones = new Operacion(sueldo);

			Thread hilo = new Thread(operaciones);
			
			Thread hilo2 = new Thread(operaciones);
			
			hilo.run();
			
			hilo2.run();
	}
}

//Clase Operacion
class Operacion extends Thread{
	
	//Variable de saldo
	int sueldo ;
	//Creamos el Semaforo con valor en 1
	Semaphore s = new Semaphore (1);
	
	//Constructor
	public Operacion (int sueldo) {
		this.sueldo = sueldo;
	}
	
	//Metodo Runnable
	@Override
	public void run() {
	 try {
		 for (int i=0;i<10;i++) {
			 sueldo = ingresar(sueldo);
			 System.out.println("Hilo " +  Thread.currentThread().getName() + " : " + sueldo + " [INGRESO] ");
			 sueldo = retirar(sueldo);
			 System.out.println("Hilo " +  Thread.currentThread().getName() + " : " + sueldo + " [RETIRADA] ");
		 }
			 
		 
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}
	
	//Funcion de ingresar
	public int ingresar (int cantidad) throws InterruptedException  {
		s.acquire();
		cantidad = cantidad + (int)(Math.random()*300);;
		s.release();
		return cantidad;
	}
	
	//Funcion de retirar
	public int retirar (int cantidad) throws InterruptedException {
		s.acquire();
		cantidad = cantidad - (int)(Math.random()*300);
		s.release();
		return cantidad;
	}
	
	@Override
	public String toString () {
		String info = "El sueldo es de " + sueldo;
		return info;
	}
}

//Hay que hacer una clase retirar y otra ingresar que extienden de thread, en la clase operacion no hay run

