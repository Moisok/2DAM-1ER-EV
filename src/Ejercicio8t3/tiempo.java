package Ejercicio8t3;

import java.util.ArrayList;

//Metodo
class tiempo {
	//Booleana
	boolean liberar = false;
	
	//Variable de temperatura
	private int temperaturas;
	
	//Array donde almacenaremos
	ArrayList <Integer> gtemp = new ArrayList <Integer> ();
	ArrayList <Integer> gtemp2 = new ArrayList <Integer> ();
	
	//variables de busqueda minimo y maximo
	private int minimo = 0;
	private int maximo = 10;
	
	//Metodo donde crearemos las 100 temperaturas
	public void temp () {
		temperaturas = (int)(Math.random()*(55 - 0));
		temperaturas = temperaturas - 10;
		gtemp.add(temperaturas);
	}
	
	//Metodo Sincronizado donde los hilos fracionaran de 10 en 10 y buscaran el maximo valor
	public void busqueda () {
		int maxim = gtemp.get(0);
		for (int i=minimo;i<maximo;i++) {
				if (maxim<gtemp.get(i)) {
					maxim = gtemp.get(i);
				};
		}
		System.out.println(Thread.currentThread().getName() + " Ha encontrado de maximo " + maxim+"º");
		gtemp2.add(maxim);
		minimo = minimo + 10;
		maximo = maximo + 10;
		if (minimo == 100) {
			liberar = true;
		}
	}
	
	public void busqueda2 () {
		if (liberar == true) {
			int maxim2 = gtemp2.get(0);
			for (int i=0;i<gtemp2.size();i++) {
					if (maxim2<gtemp2.get(i)) {
						maxim2 = gtemp2.get(i);
					};
			}
			System.out.println("Maxima: " + maxim2 + "º");
			
		}
	}
}
