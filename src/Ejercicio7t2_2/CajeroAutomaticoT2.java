package Ejercicio7t2_2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

public class CajeroAutomaticoT2 {
	
	//Clase main
	public static void main (String [] args) {
		int sueldo=(int)(Math.random()*1+1200);
		operatividad operaciones = new operatividad (sueldo);
		
		
		for (int i=0;i<5;i++) {
			new Ingresar(operaciones).start();
			new Retirar(operaciones).start();
		}
		
	}
	
}	

	//Clase para operar
		class operatividad{
			private int dinero;
			private int sueldo = 0;
			private int total = 0;
			//Semaforo
			Semaphore semaforo = new Semaphore (1);

			//Constructor
			operatividad(int sueldo){
				this.sueldo = sueldo;
			}
			
			//Getter
			public int getSueldo() {
				return sueldo;
			}
			
			//Getter
			public int getDinero() {
				return dinero;
			}
			
			//Setter
			public void setSueldo(int sueldo) {
				this.sueldo = sueldo;
			}

			//Clase donde iremos devolviendo el sueldo
			int ingresarDinero() throws InterruptedException{
				semaforo.acquire();
				//Seccion critica
				System.out.println("[INGRESO]:" + " SALDO RESTANTE: " + sueldo + " " + Thread.currentThread().getName());
				dinero = (int)(Math.random()*1200);
				System.out.println("[INGRESO]:" + " INGRESO: " + dinero + " " + Thread.currentThread().getName());
				total = sueldo + dinero;
				System.out.println("[INGRESO]:" + " TOTAL:" + total + " " + Thread.currentThread().getName());
				sueldo = total;
				if (sueldo < 0) {
					System.err.println("[ATENCION SALDO NEGATIVO]: " + sueldo);
				}
				//Liberamos el semaforo
				semaforo.release();
				return total;
			}
			
			int retirarDinero() throws InterruptedException{
				semaforo.acquire();
				//Seccion critica
				System.out.println("[RETIRADA]:" + " SALDO RESTANTE: " + sueldo + " " + Thread.currentThread().getName());
				dinero = (int)(Math.random()*1200);
				System.out.println("[RETIRADA]:" + " RETIRADA: " + dinero + " " + Thread.currentThread().getName());
				total = sueldo - dinero;
				System.out.println("[RETIRADA]:" + " TOTAL:" + total + " " + Thread.currentThread().getName());
				sueldo = total;
				if (sueldo < 0) {
					System.err.println("[ATENCION SALDO NEGATIVO]: " + sueldo);
				}
				//Liberamos el semaforo
				semaforo.release();
				return total;
			}
		}
	
	
		
	//Clase de ingresar [HILO1]
	class Ingresar extends Thread{
		//Creamos el objeto operatividad
		operatividad Operaciones;
		//Constructor donde pasaremos la clase de operaciones
		Ingresar (operatividad Operaciones){
			this.Operaciones = Operaciones;
		}
		@Override
		public void run() {
				try {
					Operaciones.ingresarDinero();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
	//Clase de retirar [HILO2]
	class Retirar extends Thread{
		//Creamos el objeto operatividad
		operatividad Operaciones;
		//Constructor donde pasaremos la clase de operaciones
		Retirar (operatividad Operaciones){
			this.Operaciones = Operaciones;
		}
		@Override
		public void run() {
				try {
					Operaciones.retirarDinero();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
}
	


