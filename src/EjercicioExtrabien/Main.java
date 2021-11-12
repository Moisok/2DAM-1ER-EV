package EjercicioExtrabien;
import java.time.LocalDateTime;
//Importamos el arraylist
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.Semaphore;


//Clase main
public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		//Escritores
		ArrayList <String> escritores = new ArrayList <String>();
		String escritor1 = "Juan Garcia";
		String escritor2 = "Alcazar Buenafuente";
		String escritor3 = "Ramon Romero";
		String escritor4 = "Jaime Ubeda";
		String escritor5 = "Moises Schwarzenegger";
		String escritor6 = "Pablo Jerez";
		String escritor7 = "Daniel dandan";
		String escritor8 = "Raul Fas";
		String escritor9 = "David Avila";
		String escritor10 = "Sergio Maldonado";
		
		escritores.add(escritor1);
		
		
		//Lectores
		ArrayList <String> lectores = new ArrayList <String>();
		String lector1 = "Fatima";
		String lector2 = "David";
		String lector3 = "Camilo";
		String lector4 = "Maria";
		String lector5 = "Eva";
		String lector6 = "Joaquin";
		String lector7 = "Pablo";
		String lector8 = "Marta";
		String lector9 = "Jorge";
		String lector10 = "Jose";
		
		
		//Llamamos al recursos
		AccesRW accesrw = new AccesRW(escritor1);
		//Llamamos al hilo
		new escritor(accesrw).start();
		new lector(accesrw).start();
	}

}

//Clase donde aremos el array, si se esta utilizando no puede entrar el siguiente
 class AccesRW {
	 //Variables
	 String componente;
	 //Constructor
	 AccesRW (String componente){
		 this.componente=componente;
	 }
	 //ArrayList con los componentes
	 ArrayList <String> componentes = new ArrayList <String>();
	 //Metodo para introducir a la gente
	 void introducir () {
		 componentes.add(componente);
	 }
	 //Metodo mostrar
	 String mostrar () {
		 return componentes.get(componentes.size()-1);
	 }
 }
	 
 
//Clase para los escritores (Escriben en la primera posicion LIBRE)
 class escritor extends Thread{
	 //variables
	 AccesRW accesRW;
	 int aleatorio;
	 boolean entrada = true;
	 Semaphore semaforo = new Semaphore(1);
	 //String escritor;
	 //Contructor
	 escritor (AccesRW accesRW){
		 this.accesRW=accesRW;
		 //this.escritor=escritor;
	 }
	 //Metodo run
	 @Override
	public
	 void run () {
		 try {
			 while (entrada) {
			 semaforo.acquire();	 
			 aleatorio = (int)(Math.random()*5000);
			 accesRW.introducir();
			 System.out.println("[ESCRITOR]:" + " [ENTRA]" + " " + Thread.currentThread().getName() );
			 System.out.println("[ESCRITOR]:" + " Soy: " + accesRW.mostrar() + " " + LocalDateTime.now() + " " + Thread.currentThread().getName());
			 System.out.println("[ESCRITOR]:" + " [SALE]" + " " + Thread.currentThread().getName());
			 semaforo.release();
			 accesRW.componentes.remove(0);
			 Thread.sleep(aleatorio);
			 }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
 }
 
//Clase para los lectores (ENTRA EN EL PRIMER ELEMENTO DEL ARRAY)
 class lector extends Thread{
	 //variables
	 AccesRW accesRW;
	 int aleatorio;
	 boolean entrada = true;
	 Semaphore semaforo = new Semaphore(1);
	 //Contructor
	 lector (AccesRW accesRW){
		 this.accesRW=accesRW;
	 }
	 //Metodo run
	 @Override
	public
	 void run () {
		//Mostramos
		 try {
			 while(entrada) {
				 if(accesRW.componentes.isEmpty())
			 semaforo.acquire();	
			 aleatorio = (int)(Math.random()*5000);
			 accesRW.introducir();
			 System.out.println("[LECTOR]:" + " [ENTRA]" + " " + Thread.currentThread().getName());
			 System.out.println("[LECTOR]:" + " Soy: " + accesRW.mostrar() + " y estoy leyendo" + Thread.currentThread().getName());
			 System.out.println("[LECTOR]:" + " [SALE]" + " " + Thread.currentThread().getName());
			 semaforo.release();
			 Thread.sleep(aleatorio);
			 }
		 }catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
	 }
	
 }



