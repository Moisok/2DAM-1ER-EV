package Ejercicio6t3;

public class hilo3 extends Thread {
	
	auxiliar aux3;
	
	hilo3 (auxiliar aux3){
		this.aux3 = aux3;
	}
	
	@Override
	public void run() {
		
		aux3.auxiliar3();
		
	}
}
	


