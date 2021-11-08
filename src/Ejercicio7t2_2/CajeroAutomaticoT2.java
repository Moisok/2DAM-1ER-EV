package Ejercicio7t2_2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

public class CajeroAutomaticoT2 {
	
	//Clase main
	public static void main (String [] args) {
		//Invocamos a la clase temporizador
		Timer time=new Timer();					
	    MyTask task=new MyTask();					
	    time.schedule(task, 0,1000);
	}
	
}	

	//Clase temporizador
		class MyTask extends TimerTask{
			//Variable donde generamos el sueldo
			int sueldo=(int)(Math.random()*1200);
			//Ahora llamamos a la clase Operatividad
			operatividad operaciones = new operatividad (sueldo);
			  public void run(){							
				new Ingresar(operaciones).start();
				new Retirar(operaciones).start();	
			  }
		}


	//Clase para operar
		class operatividad{
			private int sueldo = 0;
			//Constructor
			operatividad(int sueldo){
				this.sueldo = sueldo;
			}
			
			//Getter
			public int getSueldo() {
				return sueldo;
			}
			
			//Setter
			public void setSueldo(int sueldo) {
				this.sueldo = sueldo;
			}

			//Clase donde iremos devolviendo el sueldo
			int generarAleatorio(){
				int dinero=(int)(Math.random()*1200);
				sueldo = sueldo + dinero;
				return sueldo;
			}
		}
	
	
		
	//Clase de ingresar [HILO1]
	class Ingresar extends Thread{
		//Creamos el Semaforo con valor en 1
		Semaphore s = new Semaphore (1);
		//Creamos el objeto operatividad
		operatividad Operaciones;
		//Constructor donde pasaremos la clase de operaciones
		Ingresar (operatividad Operaciones){
			this.Operaciones = Operaciones;
		}
		@Override
		public void run() {
			try {
				s.acquire();
				int saldo = Operaciones.getSueldo();
				System.out.println(Thread.currentThread().getName() + " SALDO RESTANTE: " + Operaciones.getSueldo());
				int ganancias = Operaciones.generarAleatorio();
				System.out.println(Thread.currentThread().getName() + " INGRESO: " + ganancias);
				int suma = saldo + ganancias;
				if (suma < 0) {
					System.err.println(Thread.currentThread().getName() + " TOTAL:" + suma + " [SALDO NEGATIVO]");
				}
				else {
					System.out.println(Thread.currentThread().getName() + " TOTAL:" + suma);
				}
				s.release();
				Operaciones.setSueldo(suma);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	//Clase de retirar [HILO2]
	class Retirar extends Thread{
		//Creamos el Semaforo con valor en 1
		Semaphore s = new Semaphore (1);
		//Creamos el objeto operatividad
		operatividad Operaciones;
		//Constructor donde pasaremos la clase de operaciones
		Retirar (operatividad Operaciones){
			this.Operaciones = Operaciones;
		}
		@Override
		public void run() {
			try {
				s.acquire();
				int saldo = Operaciones.getSueldo();
				System.out.println(Thread.currentThread().getName() + " SALDO RESTANTE: " + Operaciones.getSueldo());
				int retirada = Operaciones.generarAleatorio();
				System.out.println(Thread.currentThread().getName() + " RETIRADA: " + retirada);
				int resta = saldo - retirada;
				if (resta < 0) {
					System.err.println(Thread.currentThread().getName() + " TOTAL:" + resta + " [SALDO NEGATIVO]");
				}
				else {
					System.out.println(Thread.currentThread().getName() + " TOTAL:" + resta);
				}
				s.release();
				Operaciones.setSueldo(resta);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
}
	


