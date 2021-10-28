package EjercicioExtra1T2;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Ejercicio extra donde mostraremos cada cierto tiempo una frase sobre la salud
//Creado por Moises Sepulveda Segarra

public class FarmaciaCartel {

	public static void main( String [] args) throws InterruptedException, ExecutionException {
		
		ScheduledExecutorService schExService = Executors.newScheduledThreadPool(1);
		
		Cartel mensajes = new Cartel();
		
		//El primer mensaje sale en el segundo 0, los demas cada 5 segundos
		schExService.scheduleWithFixedDelay(mensajes, 0, 5, TimeUnit.SECONDS);
			
		//Se ejecuta durante 60 segundo es decir un minuto
		schExService.awaitTermination(60, TimeUnit.SECONDS);
		
		//Cuando termina el tiempo, runnable se acaba
		schExService.shutdownNow();
		
		//Mensaje de cuando termina
		System.out.println("He terminado");
		
	}

}

class Cartel implements Runnable {
	int contador = 0;
	//int contador2 = 0;
	String mensaje1 = "Hidratate bien";
	String mensaje2 = "Consume 5 lacteos al dia";
	String mensaje3 = "Come 3 piezas de fruta al dia";
	String mensaje4 = "No fumes";
	String mensaje5 = "Haz deporte";
	ArrayList <String> mensaje = new ArrayList <String> ();
	
	
	@Override
	public void run() {
		int random = (int)(Math.random()*4);
		mensaje.add(mensaje1);
		mensaje.add(mensaje2);
		mensaje.add(mensaje3);
		mensaje.add(mensaje4);
		mensaje.add(mensaje5);
		System.out.println(mensaje.get(random) + " (Segundo:[" +contador+ "])");
		contador = contador + 5;
		/*contador2 = contador2 + 1;
		if (contador2 == 5) {
			contador2=0;
		}*/
	}
}
	

