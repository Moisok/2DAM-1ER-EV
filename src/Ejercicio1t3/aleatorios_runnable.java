package Ejercicio1t3;

public class aleatorios_runnable implements Runnable {
	int aleatorio;
	@Override
	public
	void run () {
		aleatorio = (int)(Math.random()*500);
		System.out.println("Numero generado es :"+ aleatorio);
	}
}
