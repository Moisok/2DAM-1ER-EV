package Ejercicio6t3;

public class hilo2 extends Thread {
	
	auxiliar aux2;
	
	hilo2 (auxiliar aux2){
		this.aux2 = aux2;
	}
	
	@Override
	public void run() {
		aux2.auxiliar2();
	}
}
