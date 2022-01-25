package Ejercicio_examen2;

import java.util.ArrayList;

public class tienda {
	
	
	//ArrayList
	ArrayList <String> Comandas = new ArrayList <String>();
	
	ArrayList <String> ComandasPreparadas = new ArrayList <String>();
	
	ArrayList <String> RepartirComanda = new ArrayList <String>();
	
	//Variables
	private int cogerComanda;
	
	//private int comandasRepartidas;
	private int numeroPreparadas = 0;
	
	boolean comandaEnCamino = false;
	
	//Metodo para llenar el array hasta 30
	public synchronized void introComandas (String cliente) {
		
		Comandas.add(cliente);
		
		System.out.println(cliente + " hace hace un pedido");
		
		if (Comandas.size()==30) {
			
			notifyAll();
			
		}
		
	}
	
	//Metodo para preparar la comanda
	public synchronized void prepararComanda (String trabajador) {
		
		//Condicion comprobacion
		while(Comandas.size()<=0) {	
			
			try {
				
				wait();
				
			}catch(InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
			//cogerComanda = (int)(Math.random()*(Comandas.size()-0));
			
			System.out.println("[PREPARAR] " + trabajador + ": prepara la comanda de : " + Comandas.get(0));
			
			ComandasPreparadas.add(Comandas.get(0));
			
			Comandas.remove(0);
			
			notify();
	}
	
	//Metodo para indicar que la comanda ya esta preparada
	public synchronized void ComandaPreparada (String trabajador) {
		//Condicion comprobacion
		while(ComandasPreparadas.size()<0) {
			
			try {
				
				wait();
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
		
		//Las "cogemos" por orden de llegada
		System.out.println("[PREPARAR] " + trabajador + ": ya ha preparado la comanda de : " + ComandasPreparadas.get(0));
		
		RepartirComanda.add(ComandasPreparadas.get(0));
			
		ComandasPreparadas.remove(0);
		
		numeroPreparadas++;
		
	}
	
	//Metodo para los repatidores (CORREGIR)
	public synchronized void repartirComanda (String repartidor) {
		while (numeroPreparadas==0) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}	
		
		cogerComanda = (int)(Math.random()*RepartirComanda.size()-0);
			
		System.out.println("[REPARTIR] " + repartidor + " reparte la comanda de :" + RepartirComanda.get(cogerComanda));
		
		RepartirComanda.remove(cogerComanda);
		
		comandaEnCamino = true;
		
		numeroPreparadas--;
	 
	}
	
	//Metodo para finalizar el pedido
	public synchronized void finalizarPedido (String repartidor) {
		
		while (!comandaEnCamino) {
			try {
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		System.out.println("[REPARTIR] " + repartidor + " ya ha llevado la comanda a su destino");
		
		
		if (RepartirComanda.size()==0) {
			
			comandaEnCamino = false;
		}
		
	}
	
}
