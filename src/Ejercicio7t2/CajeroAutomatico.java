package Ejercicio7t2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Semaphore;

public class CajeroAutomatico {
	
	public static void main (String [] args) {
		
			int sueldo = 1800;
		
			Operacion operaciones = new Operacion(sueldo);

			Thread hilo = new Thread(operaciones);
			
			Thread hilo2 = new Thread(operaciones);
			
			hilo.start();
			
			hilo2.start();

	}

}

//Clase Operacion
class Operacion implements Runnable{
	
	//Variable de saldo
	int sueldo ;
	//Creamos el Semaforo con valor en 0
	Semaphore s = new Semaphore (0);
	
	//Constructor
	public Operacion (int sueldo) {
		this.sueldo = sueldo;
	}
	
	//Metodo Runnable
	@Override
	public void run() {
	 try {
			 sueldo = ingresar(sueldo);
			 System.out.println(sueldo + " [INGRESO] " + s.availablePermits() + " " + Thread.currentThread().getName());
			 sueldo = retirar(sueldo);
			 System.out.println(sueldo + " [RETIRADA] " + s.availablePermits() + " " + Thread.currentThread().getName());
		 
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}
	
	//Funcion de ingresar
	public int ingresar (int cantidad) throws InterruptedException  {
		s.acquire(0);
		cantidad = cantidad + (int)(Math.random()*300);;
		s.release();
		return cantidad;
	}
	
	//Funcion de retirar
	public int retirar (int cantidad) throws InterruptedException {
		s.acquire(0);
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


