package Ejercicio_examen2;

public class main {

	public static void main(String[] args) throws InterruptedException {
		//Variables
		String cliente_nombre;
		
		String trabajador_nombre;
		
		String repartidor_nombre;
		
		//Invocamos al objeto
		
		tienda restaurante = new tienda ();
		
		//Creamos los arrays
		
		cliente [] Clientes = new cliente [30];
		
		trabajador [] Trabajadores = new trabajador [3];
		
		repartidor [] Repartidores = new repartidor [3];
		
		//Creamos bucles
		
		for (int i=0;i<30;i++) { 
			cliente_nombre = "cliente " + i; 
			Clientes[i] = new cliente(restaurante,cliente_nombre);
			Clientes[i].start();
		}
		

		
		for (int i=0;i<3;i++) {
			trabajador_nombre = "trabajador " + i;
			Trabajadores [i] = new trabajador(restaurante,trabajador_nombre);
			Trabajadores[i].start();
		}
		
		
		for (int i=0;i<3;i++) {
			repartidor_nombre = "repartidor " + i;
			Repartidores [i] = new repartidor(restaurante,repartidor_nombre);
			Repartidores[i].start();
		}
		
		
		
	}

}
