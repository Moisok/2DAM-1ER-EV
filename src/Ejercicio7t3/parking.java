package Ejercicio7t3;

//Programa creado por Moises Sepulveda Segarra
//He creado un sistema de "dados donde segun el numero que toque se abandona el parking o no

import java.util.ArrayList;

//Clase Principal
public class parking {
	
	public static void main(String[]args) {
		
		accesRW parkings = new accesRW();
		
		hilo1 aparca = new hilo1(parkings);
		
		hilo2 salida = new hilo2(parkings);
		
		aparca.start();
		
		salida.start();
		
	}
}


//Clase Auxiliar
class accesRW {
	
	//Arraylist
	ArrayList <Integer> plazas = new ArrayList<Integer>();
	//Coches
	int coches;
	//Plazas libre
	int libres = 10;
	//minutos
	int minutos = 60;
	//tiempo
	int tiempo;
	//Numero random para que abandonen el parking
	int abandonar;
	//Condiciones
	boolean park = true;
	boolean lib_park = false;
	
	//Funcion sincronizada
	synchronized void parking() {
		while (!park) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			if (minutos > 0) {
				if (plazas.size() == 10) {
					System.out.println("No hay plazas libres");
					notify();
					park = false;
					lib_park = true;
				}else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					coches = (int)(Math.random()*(40 - 1)+1);
					libres--;
					System.out.println("Llega el coche con matricula ["+coches+"] plazas libres ["+libres+"]");
					plazas.add(coches);
					minutos--;
					notify();
					park = false;
					lib_park = true;
			}
		}
	}
	
	//Funcion Sincronizada
	synchronized void salida_parking() {
		while(!lib_park) {
			try {
				wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		abandonar = (int)(Math.random()*(5 - 1)+1);
		if (abandonar == 4 || abandonar == 5 || abandonar == 6) {
			tiempo = (int)(Math.random()*(30000 - 1000)+1000);
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			libres++;
			System.out.println("El coche con matricula ["+ plazas.get(plazas.size()-1)+"] abandona el parking plazas libres ["+libres+"]\n");
			plazas.remove(plazas.size()-1);
			notify();
			park = true;
			lib_park = false;
		}
		else {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Ningun coche abandona el parking\n");
			notify();
			park = true;
			lib_park = false;
		}
	}
}

//Hilo para aparcar
class hilo1 extends Thread {
	accesRW accesrw;
	hilo1 (accesRW accesrw){
		this.accesrw = accesrw;
	}
	@Override
	public void run() {
		for (int i=0;i<40;i++) {
			accesrw.parking();
		}
	}
}

//Hilo para liberar
class hilo2 extends Thread {
	accesRW accesrw;
	hilo2 (accesRW accesrw){
		this.accesrw = accesrw;
	}
	@Override
	public void run() {
		for (int i=0;i<40;i++) {
			accesrw.salida_parking();;
		}
	}
}

