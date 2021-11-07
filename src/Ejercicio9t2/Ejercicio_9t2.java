package Ejercicio9t2;

//Ejercicio 9 creado por Moises Sepulveda Segarra

public class Ejercicio_9t2 {
	public static void main(String[] args) {
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
class contador {
	//Variable entera con la tandiad acumulada
	int cantidad;
	int aleatorio = (int)(Math.random()*5000);
	//Contructor para pasarle el numero
	contador (int cantidad){
		this.cantidad = cantidad;
	}
	//Metodo para saber si es par o no par e ir incrementando o decrementando
	int genereaAleatorio () {
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
	public void run() {
	System.out.println("Hilo" + Thread.currentThread().getName() + " [" + Contador1.genereaAleatorio() + "]");
		
	}	
}