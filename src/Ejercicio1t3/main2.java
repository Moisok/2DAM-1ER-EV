package Ejercicio1t3;

public class main2 {
	public static void main(String[] args) {
		for (int i=0;i<5;i++) {
			aleatorios_runnable r1 = new aleatorios_runnable();
			new Thread(r1).start();
		}
	}

}
