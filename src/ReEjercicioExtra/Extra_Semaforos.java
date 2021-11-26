package ReEjercicioExtra;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

//Re-Ejercicio hecho ya que la ultima vez lo hice mal

public class Extra_Semaforos {

	public static void main(String[] args) {
		//Llamamos a la funcion
		AccesRW rw = new AccesRW();
		
		for(int i=0;i<10;i++) {
			new Escritor("Escritor"+i,rw).start();
		}
		
		for(int i=0;i<10;i++) {
			new Lector("Lector"+i,rw).start();
		}
	}
}

//Clase Acces RW donde tendremos el Array y los metodos
class AccesRW {
	//Creamos el Array De String
	private ArrayList<String> Componentes = new ArrayList<String>();
	//Creamos los dos semaforos, uno con el contador a 1 y el de 
	//lectores lo ponemos a 0
	private Semaphore sem_acc = new Semaphore(1);
	private Semaphore sem_lec = new Semaphore(0);
	
	//Esta clase es para obetener la fecha y la hora
	public String getTime() {
		LocalDateTime locaDate = LocalDateTime.now();
		int horas = locaDate.getHour();
		int minutos = locaDate.getMinute();
		int segundos = locaDate.getSecond();
		return horas + " : " + minutos + " : " + segundos;
	}
	
	//Metodo para escribir
	public void escribir(String escribe) {
		try {
			Random r = new Random();
			Thread.sleep((r.nextInt(5)+1)*1000);
			System.out.println(escribe + " intentando escribir");			
			//Semaforo de acceso lo ponemos en rojo
			sem_acc.acquire();
			this.Componentes.add("Soy " + escribe+" y son las " +this.getTime());
			//Liberamos el semaforo de aceso lectores
			sem_lec.release();
			System.out.println(escribe + "-Elementos restantes: " + sem_lec.availablePermits());
			//Liberamos el semaforo de acceso general
			sem_acc.release();		
		}catch(InterruptedException ex) {
			System.err.println("Error en la ejecucion de escribir");
		}
	}
	
	//Metodo para Leer
	public void leer(String lee) {
		try {
			Random r = new Random();
			Thread.sleep((r.nextInt(5)+1)*1000);
			System.out.println(lee + " Intentando leer");
			//Bloqueamos semaforo de lectores
			sem_lec.acquire();
			System.out.println(lee + " - Elementos restantes: " + sem_lec.availablePermits());
			//Bloqueamos semaforo de escritores
			sem_acc.acquire();
			System.out.println(lee + " lee: " + this.Componentes.get(0));
			this.Componentes.remove(0);
			//Liberamos semaforo de acceso
			sem_acc.release();
			
		}catch(InterruptedException ex) {
			System.err.println("Error en la ejecucion de escribir");
		}
	}
}

//Proceso o hilo de Lector
class Lector extends Thread{
	private AccesRW rw;
	private String nombre;
	Lector(String nombre, AccesRW rw){
		this.rw=rw;
		this.nombre=nombre;
	}
	@Override
	public void run() {
		rw.leer(this.nombre);
	}
}

//Proceso o hilo del escritor
//Proceso o hilo de Lector
class Escritor extends Thread{
	private AccesRW rw;
	private String nombre;
	Escritor(String nombre, AccesRW rw){
		this.rw=rw;
		this.nombre=nombre;
	}
	@Override
	public void run() {
		rw.escribir(this.nombre);
	}
}



