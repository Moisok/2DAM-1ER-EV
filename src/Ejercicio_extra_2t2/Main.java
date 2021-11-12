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
	 int contador;
	 //ArrayList
	 ArrayList <String> componentes = new ArrayList <String>();
	 //Semaforos
	 Semaphore semaforo1 = new Semaphore(1);

	 
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
		semaforo1.acquire();
		int random2 = random;
		contador++;
		componentes.add(escritores.get(random2));
		System.out.println("[ESCRITOR]: " + " EMPIEZA " + Thread.currentThread().getName());
		System.out.println("[ESCRITOR]: " + "Soy " + componentes.get(0) + " y es: " + LocalDateTime.now() + " " +  Thread.currentThread().getName());
		semaforo1.release();
		System.out.println("[ESCRITOR]: " + "ACABA " + Thread.currentThread().getName());
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
		semaforo1.acquire();
		int random2 = random;
		contador++;
		System.out.println("[LECTOR]: " + componentes.remove(0) + " [HA SIDO ELIMINADO DEL ARRAY] " + Thread.currentThread().getName());
		componentes.add(lectores.get(random2));
		System.out.println( "[LECTOR]: " + "EMPIEZA " + Thread.currentThread().getName());
		System.out.println( "[LECTOR]: " +  "Soy " + componentes.get(0) + " y estoy leyendo un libro " +  Thread.currentThread().getName());
		semaforo1.release();
		System.out.println( "[LECTOR]: " +  "ACABA " + Thread.currentThread().getName());
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
		 		random=(int)(Math.random()*9);
		 		accesRW.listarLector(random);
				espera = (int)(Math.random()*5000);
				Thread.sleep(espera);
		 		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}



/*String escritor1 = "Juan Garciae";
String escritor2 = "Alcazar Buenafuente";
String escritor3 = "Ramon Romero";
String escritor4 = "Jaime Ubeda";
String escritor5 = "Moises Schwarzenegger";
String escritor6 = "Pablo Jerez";
String escritor7 = "Daniel dandan";
String escritor8 = "Raul Fas";
String escritor9 = "David Avila";
String escritor10 = "Sergio Maldonado";*/

/*
/*String lector1 = "Fatima";
String lector2 = "David";
String lector3 = "Camilo";
String lector4 = "Maria";
String lector5 = "Eva";
String lector6 = "Joaquin";
String lector7 = "Pablo";
String lector8 = "Marta";
String lector9 = "Jorge";
String lector10 = "Jose";*/