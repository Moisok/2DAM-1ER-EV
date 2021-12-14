package Ejercicio4t3;

//Clase principal
public class Saludar {

	public static void main(String[] args) {
		
		saludarydespedirse syd = new saludarydespedirse();
		
		saludar saludos = new saludar (syd);
		
		despedida despidos = new despedida (syd);
		
		saludos.start();
		
		despidos.start();

	}

}

//Clase Auxiliar
class saludarydespedirse {
	
	boolean despedida = false;
	
	synchronized void saludar () {
		System.out.println("Hola");
		notify();
		despedida = true;
	}
	
	synchronized void despedirse () {
		if (!despedida) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();	
			}
		}
		else {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Adios");
			despedida = false;
		}
	}
}


//Hilo de saludar
class saludar extends Thread {
	
	saludarydespedirse syd;
	
	saludar (saludarydespedirse syd){
		this.syd = syd;
	}
	
	@Override
	public void run () {
		syd.saludar();
	}
	 
}

//Hilo de despedirse
class despedida extends Thread {
	
	saludarydespedirse syd;
	
	despedida (saludarydespedirse syd){
		this.syd = syd;
	}
	
	@Override
	public void run () {
		syd.despedirse();
	}
	 
}










