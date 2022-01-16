package Ejercicio8t3;
import java.util.ArrayList;

public class Ejercicio8_temperaturas {

	public static void main (String[] args) throws InterruptedException {
		
		tiempo temperaturas = new tiempo();
		System.out.println("Introduciendo 100 temperaturas...\n");
		for (int i=0;i<100;i++) {
			temperaturas.temp();
		}
		
		for (int j=0;j<10;j++) {
			new search(temperaturas).start();
		}
		
		new search2(temperaturas).start();
	
		
	}
}

//Metodo
class tiempo {
	//Booleana
	boolean liberar = false;
	
	//Variable de temperatura
	private int temperaturas;
	
	//Array donde almacenaremos
	ArrayList <Integer> gtemp = new ArrayList <Integer> ();
	
	
	//variables de busqueda minimo y maximo
	private int minimo = 0;
	private int maximo = 10;
	
	//temperaturas minimas y maximas
	private int tempmin = 15;
	private int tempmax = 45;
	
	//Metodo donde crearemos las 100 temperaturas
	synchronized public void temp () {
		temperaturas = (int)(Math.random()*((tempmax + (-tempmin))));
		gtemp.add(temperaturas);
	}
	
	//Metodo Sincronizado donde los hilos fracionaran de 10 en 10 y buscaran el maximo valor
	synchronized void busqueda () {
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		int maxim = gtemp.get(0);
		for (int i = minimo;i<maximo;i++) {
				if (maxim<gtemp.get(i)) {
					maxim = gtemp.get(i);
				};
		}
		System.out.println(Thread.currentThread().getName() + " Ha encontrado de maximo " + maxim+"º");
		minimo = minimo + 10;
		maximo = maximo + 10;
		if (maximo == 100) {
			notify();
			liberar = true;
		}
	}
	
	synchronized void busqueda2 () {
		while (!liberar) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int maxim = gtemp.get(0);
		for (int i=0;i<gtemp.size();i++) {
				if (maxim<gtemp.get(i)) {
					maxim = gtemp.get(i);
				};
		}
		System.out.println("Maxima: " + maxim + "º");
	}
}

//Hilos
class search extends Thread{
	tiempo temps;
	search (tiempo temps){
		this.temps = temps;
	}
	@Override
	public void run() {
		temps.busqueda();
	}
}

//Hilos
class search2 extends Thread{
	tiempo temps;
	search2 (tiempo temps){
		this.temps = temps;
	}
	@Override
	public void run() {
		temps.busqueda2();
	}
}

