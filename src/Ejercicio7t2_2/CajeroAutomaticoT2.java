package Ejercicio7t2_2;

import java.util.concurrent.Semaphore;

public class CajeroAutomaticoT2 {
	
	//Clase main
	public static void main (String [] args) {
		
		boolean operacion = true;
		
		int sueldo=(int)(Math.random()*1+1200);
		
		operatividad operaciones = new operatividad (sueldo);
		
		//Creamos los objetos
		Ingresar ingresos = new Ingresar (operaciones);
		Retirar retiradas = new Retirar (operaciones);
		
		//Bucle
		ingresos.start();
		retiradas.start();
		
		
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
		boolean ingresar = true;
		//Creamos el objeto operatividad
		operatividad Operaciones;
		//Constructor donde pasaremos la clase de operaciones
		Ingresar (operatividad Operaciones){
			this.Operaciones = Operaciones;
		}
		//numero aleatorio
		int espera;
		@Override
		public void run() {
				try {
					while(ingresar) {
						Operaciones.ingresarDinero();
						espera = (int)(Math.random()*5000);
						Thread.sleep(espera);
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
	//Clase de retirar [HILO2]
	class Retirar extends Thread{
		boolean retirar = true;
		//Creamos el objeto operatividad
		operatividad Operaciones;
		//Constructor donde pasaremos la clase de operaciones
		Retirar (operatividad Operaciones){
			this.Operaciones = Operaciones;
		}
		//numero aleatorio
		int espera;
		//ponemos nombre al hilo
		@Override
		public void run() {
				try {
					while(retirar) {
						Operaciones.retirarDinero();
						espera = (int)(Math.random()*5000);
						Thread.sleep(espera);
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
}
	


