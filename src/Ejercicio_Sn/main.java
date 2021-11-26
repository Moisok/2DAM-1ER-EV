// Creado por Moises Sepulveda Segarra
// 2CFGS
package Ejercicio_Sn;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

// Clase Main
public class main {

	public static void main(String[] args) {
		
		//Llamamos al objeto restaurante
		tienda restaurante = new tienda();
		
		//Bucle para trabajadores
				for (int i=0;i<2;i++) {
					new trabajadores(restaurante,i).start();
				}
		
		//Bucle para clientes
				for (int i=1;i<30;i++) {
					new clientes(restaurante,i).start();
				}
	}

}

// Clase de la tienda
class tienda {
	
	//Creamos las variables
	
	
	private int comanda = 0;
	
	
	
	//Creamos un ArraList
	ArrayList componentes = new ArrayList();
	
	//Creamos el semaforo
	Semaphore semaforo_acceso = new Semaphore(1);
	
	Semaphore semaforo2_clientes = new Semaphore(0);
	
	//Funcion para trabajadores
	public void trabajadores (int trabajadores) {
		try {
						System.out.println("Trabajador " + trabajadores + " Esperando comandas");
					
						semaforo_acceso.acquire();
						
						semaforo2_clientes.release();
						
						if (!componentes.isEmpty()) {
							System.out.println("Trabajador " + trabajadores + " preparando la comanda de cliente: " + componentes.size());
							
							int numeroAleatorio = (int) (Math.random()*10000+15000);
							
							Thread.sleep(numeroAleatorio);
								
							comanda--;
							
							System.out.println("Trabajador " + trabajadores + " ha terminado la comida de : " + componentes.size() + " comandas pendientes " + comanda);
						}
							
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		
	}
	
	//Funcion para los clientes
	public void clientes (int cliente) throws InterruptedException {
		
				semaforo2_clientes.acquire();
	
				Thread.sleep(12000);
				
				comanda++;
				
				System.out.println ("Cliente " + cliente + " ha hecho una comanda - comandas pendientes " + comanda);
				
				componentes.add(cliente);
				
				semaforo_acceso.release();
				
	}
	
}

//Hilo de trabajadores
class trabajadores extends Thread {
	//Variables de hilo
	
	boolean infinito = true;
	
	tienda restaurante;
	
	int trabajadores = 0;
	
	//Constructor
	
	trabajadores (tienda restaurante, int trabajadores){
		this.restaurante=restaurante;
		
		this.trabajadores=trabajadores;
	}
	//Run
	@Override
	public void run () {
			while (infinito) {
				restaurante.trabajadores(trabajadores);
			}
	}
}

//Hilo de clientes
class clientes extends Thread {
	//Variables de hilo
	tienda restaurante;
	
	int clientes;
	
	//Constructor
	
	clientes (tienda restaurante, int clientes){
		this.restaurante=restaurante;
		
		this.clientes=clientes;
	}
	
	//Run
	@Override
	public void run () {
				try {
					restaurante.clientes(clientes);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}						
	}
}


