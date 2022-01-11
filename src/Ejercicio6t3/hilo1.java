package Ejercicio6t3;

public class hilo1 extends Thread {

	auxiliar aux1;
	
	hilo1 (auxiliar aux1){
		this.aux1 = aux1;
	}
	
	@Override
	public void run() {
		
		aux1.auxiliar1();
		
	}
}
