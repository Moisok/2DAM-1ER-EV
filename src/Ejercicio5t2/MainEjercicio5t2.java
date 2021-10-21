package Ejercicio5t2;
import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;
public class MainEjercicio5t2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//Lista de tareas que vamos a hacer en la clase en este caso 3 por que hemos puesto 3 ifs y son 3 tareas
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		
		//Creamos la lista
		List <Division> listatareas = new ArrayList<Division>();
		
		//Ahora comprobamos si son multiplos de 2 y de 3
		for (int i=0; i<=100; i++) {
				Division resultados = new Division (i);
				listatareas.add(resultados);
		}
		
		//Formato en el que recibimos los resultados y que se han generado al 
		//Ejecutar el Callable de la clase
		List <Future<Integer>> ListaResultados;
		
		//Agregamos las diferentes tareas a la lista de resultados
		ListaResultados = executor.invokeAll(listatareas);
	
		//Apagamos y mostramos el numero de tareas, ya no ara mas y ademas las que estaban en ejecucion se apagan
		System.out.println("Se han realizado " + executor.getCompletedTaskCount() + " tareas y hay " + executor.getPoolSize() + " hilos en ejecucion");
		executor.shutdown();
		
		System.out.println(" ");
		//Listamos
		//Multiplos de 2
		System.out.println("Multiplos de 2");
		for (int i=0;i<listatareas.size();i++) {
			Future<Integer> resultados = ListaResultados.get(i);
			try {
				if (resultados.get() != 0 && resultados.get() % 2 == 0) {
					System.out.print(resultados.get());
					System.out.print(" ");
				}
				
			}
			catch (InterruptedException | ExecutionException e) {
				
			}
		}

		//Ahora listamos los multiplos de 3
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Multiplos de 3");
		for (int i=0;i<listatareas.size();i++) {
			Future<Integer> resultados = ListaResultados.get(i);
			try {
				if (resultados.get() != 0 && resultados.get() % 3 == 0) {
					System.out.print(resultados.get());
					System.out.print(" ");
				}
			}
			catch (InterruptedException | ExecutionException e) {
				
			}
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Ahora hay " + executor.getPoolSize() + " hilos en ejecucion");

	}

}
