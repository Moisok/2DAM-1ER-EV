package Ejercicio4t2;

//Programa que simula el algoritmo de planificacion FCFS 
//Creado por moises Sepulveda Segarra

import java.util.Timer;
import java.util.TimerTask;


public class FCFS_main {
	
	public static void main (String[]args) {
		//Contador
		int contador = 0;
		
		//Contruimos un timer
		 Timer timer;
		    timer = new Timer();
		    TimerTask task = new TimerTask() {
		    	int procesoA = 0; //Llega en 2 y tiene 6 cargas
				int procesoB = 0; //Llega en 1 y tiene 4 cargas	
				int procesoC = 0; //Llega en 3 y tiene 2 cargas
				int procesoD = 0; //Llega en 4 y tiene 6 cargas
				int procesoE = 0; //Llega en 0 y tiene 12 cargas
				int procesoF = 0;; //Llega en 3 y tiene 8 cargas
		        int segundo = 0;
		        @Override
		        public void run()
		        {
		        	segundo++;
		           if(segundo >= 0 && segundo < 13) {
		        	   procesoE++;
		        	   System.out.print("E"); 
		           }
		           else if(segundo>12&&segundo<17) {
		        	   procesoB++;
		        	   System.out.print("B");
		           }
		           else if(segundo>16&&segundo<23) {
		        	   procesoA++;
		        	   System.out.print("A");
		           }
		           else if(segundo>22&&segundo<25) {
		        	   procesoC++;
		        	   System.out.print("C");
		           }
		           else if(segundo>24&&segundo<33) {
		        	   procesoF++;
		        	   System.out.print("F");
		           }
		           else if(segundo>32&&segundo<39) {
		        	   procesoD++;
		        	   System.out.print("D");
		           }
		           if (segundo == 41) {
		        	   timer.cancel();
		        	   System.out.println(" ");
		        	   System.out.println(" ");
		        	   System.out.println("El proceso A ha llegado en 2 y ha tenido: " + procesoA + " [Cargas]");
		        	   System.out.println("El proceso B ha llegado en 1 y ha tenido: " + procesoB + " [Cargas]");
		        	   System.out.println("El proceso C ha llegado en 3 y ha tenido: " + procesoC + " [Cargas]");
		        	   System.out.println("El proceso D ha llegado en 4 y ha tenido: " + procesoD + " [Cargas]");
		        	   System.out.println("El proceso E ha llegado en 0 y ha tenido: " + procesoE + " [Cargas]");
		        	   System.out.println("El proceso F ha llegado en 3 y ha tenido: " + procesoF + " [Cargas]");
		        	   System.out.println(" ");
		        	   System.out.println("Finalizado");
		           }
		        }
		        };
		        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
		    timer.schedule(task, 10, 1000);
		
		
		
	}	
}
