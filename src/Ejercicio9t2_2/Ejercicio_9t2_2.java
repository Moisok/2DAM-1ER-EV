package Ejercicio9t2_2;
//Ejercicio 9 CON syncronized creado por Moises Sepulveda Segarra


public class Ejercicio_9t2_2 {
	public static void main(String[] args) throws InterruptedException {
		//Llamamos a las operaciones
		operaciones paroimpar = new operaciones();
		//Los hilos trabajaran sobre la clase contador
		for (int i=0;i<10;i++) {
			Thread hilo = new Thread(paroimpar);
			hilo.start();
		}
	}
}

//Clase contador
class contador extends Thread {
	//Variable entera con la tandiad acumulada
	int cantidad;
	int aleatorio = (int)(Math.random()*5000);
	//Contructor para pasarle el numero
	contador (int cantidad){
		this.cantidad = cantidad;
	}
	//Metodo para saber si es par o no par e ir incrementando o decrementando
	 int genereaAleatorio () throws InterruptedException {
		//Si el numero es par incrementa, si no decrementa
		if (aleatorio%2==0) {
			cantidad++;
			return cantidad;
		}
		else {
			cantidad--;
			return cantidad;
		}
	}
}

//Clasde Auxiliar
class operaciones extends Thread {
	//Numero
	int numero = (int)(Math.random()*300);
	//Objeto de la clase contador
	contador Contador1 = new contador(numero);
	//Aqui aremos las operaciones
	@Override
	public synchronized void run() {
		notify();
	try {
		wait();
		System.out.println("Hilo" + Thread.currentThread().getName() + " [" + Contador1.genereaAleatorio() + "]");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}	
}