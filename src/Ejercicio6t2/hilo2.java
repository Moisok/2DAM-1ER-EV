package Ejercicio6t2;

public class hilo2 extends Thread {
	public void run() {
		for (int i=1000;i<2000;i++) {
			System.out.println(i);
		}
	}

}
