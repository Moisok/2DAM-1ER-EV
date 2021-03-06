package Ejercicio_extra_2t2;
import java.time.LocalDateTime;
//Importamos el arraylist
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.Semaphore;

//Clase main
public class Main {
	public static void main(String[] args) throws InterruptedException {
		AccesRW accesrw = new AccesRW();
		new escritor(accesrw).start();
		new lector(accesrw).start();
		
	}
}

//Clase donde aremos el array
 class AccesRW {
	 //Booleano
	 boolean comprueba = false;
	 //ArrayList
	 ArrayList <String> componentes = new ArrayList <String>();
	 //Semaforo escritores
	 Semaphore semaforo = new Semaphore (1);
	//Metodo para los escritores
	 public void listarEscritor(int random) throws InterruptedException{
		ArrayList <String> escritores = new ArrayList <String>();
		escritores.add("Juan Garcia");
		escritores.add("Alcazar Buenafuente");
		escritores.add("Ramon Romero");
		escritores.add("Jaime Ubeda");
		escritores.add("Moises Schwarzenegger");
		escritores.add("Pablo Jerez");
		escritores.add("Daniel dandan");
		escritores.add("Raul Fas");
		escritores.add("David Avila");
		escritores.add("Sergio Maldonado");
		semaforo.acquire();
		int random2 = random;
		componentes.add(0,escritores.get(random2));
		System.out.println("[ESCRITOR]: " + "Soy " + componentes.get(0) + " y es: " + LocalDateTime.now() + " " +  Thread.currentThread().getName());
		comprueba=true;
		semaforo.release();
	 }
	 
	 //Metodo para los lectores SOLO ENTRAN SI HAY ESCRITORES CON DATOS
	 public  void listarLector(int random) throws InterruptedException{
		ArrayList <String> lectores = new ArrayList <String>();
		lectores.add("Fatima Tomasa");
		lectores.add("Camilo Camilito");
		lectores.add("Alex Alcantara");
		lectores.add("Marta Villarojo");
		lectores.add("Samuel Scribs");
		lectores.add("Jose Perezas");
		lectores.add("Bobby Boninas");
		lectores.add("Lourder Maldonado");
		lectores.add("Cesar perez");
		lectores.add("Paco Ramirez");
		semaforo.acquire();
		if (comprueba) {
			int random2 = random;
			componentes.add(1,lectores.get(random2));
			System.out.println( "[LECTOR]: " +  "Soy " + componentes.get(1) + " y estoy leyendo un libro de :"  +  componentes.get(0) +  Thread.currentThread().getName());
			comprueba = false;
			componentes.remove(0);
		}
		semaforo.release();
		
			}
		}
	 
//Clase para los escritores
 class escritor extends Thread{
	 //variables
	 int espera;
	 int random;
	 boolean entrada = true;
	 //Llamamos a la clase Acces
	 AccesRW accesRW;
	 //Creamos el constructor
	 escritor (AccesRW accesRW){
		 this.accesRW = accesRW;
	 }
	 //Ponemos el metodo RUN
	 @Override
	public void run() {
		 	try {
		 		while (entrada) {
		 		random=(int)(Math.random()*9);
		 		accesRW.listarEscritor(random);
				espera = (int)(Math.random()*5000);
				Thread.sleep(espera);
		 		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 
//Clase para los lectores
class lector extends Thread{
	 //variables
	 int espera;
	 int random;
	 boolean entrada = true;
	 Semaphore semaforo = new Semaphore(1);
	 //Llamamos a la clase Acces
	 AccesRW accesRW;
	 //Creamos el constructor
	 lector (AccesRW accesRW){
		 this.accesRW = accesRW;
	 }
	 //Ponemos el metodo RUN
	 @Override
	public void run() {
		 	try {
		 		while (entrada) {
		 			semaforo.acquire();
		 			random=(int)(Math.random()*9);
			 		accesRW.listarLector(random);
					espera = (int)(Math.random()*5000);
					Thread.sleep(espera);
					semaforo.release();		
		 	}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
