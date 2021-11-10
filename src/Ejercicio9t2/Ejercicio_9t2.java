package Ejercicio9t2;

//Ejercicio 9 creado por Moises Sepulveda Segarra

public class Ejercicio_9t2 {
	public static void main(String[] args) throws InterruptedException {
		//Llamamos a las operaciones
		contador contador1 = new contador();
		
		//Los hilos trabajaran sobre la clase contador
		for (int i=0;i<10;i++) {
			new operaciones(contador1).start();
		}
	}
}

//Clase contador
class contador {
	//Variable entera con la tandiad acumulada
	int cantidad = 0;
	//Contructor para pasarle el numero
	contador (){
		this.cantidad = cantidad;
	}
	//Metodo para saber si es par o no par e ir incrementando o decrementando
	 void genereaAleatorio () throws InterruptedException {
		//Si el numero es par incrementa, si no decrementa
		int aleatorio = (int)(Math.random()*5000);
		System.out.println("Hilo" + Thread.currentThread().getName() + " Contador antes: " + "[" + cantidad + "]");
		if (aleatorio%2==0) {
			cantidad = cantidad + aleatorio;
			
		}
		else {
			cantidad = cantidad - aleatorio;
			
		}
		System.out.println("Hilo" + Thread.currentThread().getName() + " Numero generado: " + " [" + aleatorio + "]");
		System.out.println("Hilo" + Thread.currentThread().getName() + " Contador despues: " + " [" + cantidad + "]");
		
	}
}

//Clasde Auxiliar
class operaciones extends Thread {
	//Numero
	//Objeto de la clase contador
	contador Contador1;
	operaciones (contador Contador1){
		this.Contador1 = Contador1;
	}
	//Aqui aremos las operaciones
	@Override
	public void run() { 
	try {
		Contador1.genereaAleatorio();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}	
}