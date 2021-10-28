package Ejercicio5t2;
import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;
public class MainEjercicio5t2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//Lista de tareas que vamos a hacer en la clase en este caso 3 por que hemos puesto 3 ifs y son 3 tareas
		//Nos tendra que devolver 3 "cosas"
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		
		//Creamos la lista
		List <Division> ListaDeTareas2 = new ArrayList<Division>();
		List <Division> ListaDeTareas3 = new ArrayList<Division>();
		
		//Ahora comprobamos si son multiplos de 2 y de 3
		for (int i=0; i<=100; i++) {
				Division calculaDivision2 = new Division(i);
				ListaDeTareas2.add(calculaDivision2);
				Division calculaDivision3 = new Division(i);
				ListaDeTareas3.add(calculaDivision3);
		}
		
		//Formato en el que recibimos los resultados y que se han generado al 
		//Ejecutar el Callable de la clase
		List <Future<Integer>> ListaResultados2;
		List <Future<Integer>> ListaResultados3;
		
		//Agregamos las diferentes tareas a la lista de resultados (cada tarea a cada hilo)
		ListaResultados2 = executor.invokeAll(ListaDeTareas2);
		ListaResultados3 = executor.invokeAll(ListaDeTareas3);
	
		//Apagamos y mostramos el numero de tareas, ya no- ara mas y ademas las que estaban en ejecucion se apagan
		System.out.println("Se han realizado " + executor.getCompletedTaskCount() + " tareas y hay " + executor.getPoolSize() + " hilos en ejecucion");
		executor.shutdown();
		
		System.out.println(" ");
		//Listamos
		//Multiplos de 2
		System.out.println("Multiplos de 2");
		for (int i=0;i<ListaResultados2.size();i++) {
			Future<Integer> resultados2 = ListaResultados2.get(i);
			try {
				if (resultados2.get() != 0 && resultados2.get() % 2 == 0) {
					System.out.print(resultados2.get());
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
		for (int i=0;i<ListaResultados3.size();i++) {
			Future<Integer> resultados3 = ListaResultados3.get(i);
			try {
				if (resultados3.get() != 0 && resultados3.get() % 3 == 0) {
					System.out.print(resultados3.get());
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


