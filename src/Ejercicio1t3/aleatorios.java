package Ejercicio1t3;

public class aleatorios extends Thread {
	int aleatorio;
	@Override
	public
	void run () {
		aleatorio = (int)(Math.random()*500);
		System.out.println("Numero generado es :"+ aleatorio);
	}
	
	
}
