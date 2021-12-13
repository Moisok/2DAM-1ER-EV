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
	
	void saludar () {
		System.out.println("Hola");
		despedida = true;
		notify();
		System.out.println(despedida);
	}
	
	synchronized void despedirse () {
		if (despedida = true) {
			try {
				wait();
				System.out.println("Adios");
				despedida = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
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










