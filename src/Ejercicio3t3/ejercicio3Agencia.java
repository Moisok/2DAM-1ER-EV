package Ejercicio3t3;

//Ejercicio 3 tema 3 "agencia de viajes" creado por moises sepulveda segarra

public class ejercicio3Agencia {

	public static void main (String [] args) throws InterruptedException {
		
		viajar viaje = new viajar();
		
		billetes compra = new billetes (viaje,1);
		billetes compra2 = new billetes (viaje,2); ;
		billetes compra3 = new billetes (viaje,3);;
		
		compra.start();
		//compra.join();
		
		compra2.start();
		//compra2.join();
		
		compra3.start();
		//compra3.join();
		
		
		
		

	}
	
}

//Clase metodo para reservar y pagar el viaje
class viajar {
	
	int comprobacion;
	
	int cliente;
	
	int plazas;
	
	boolean pagar = false;
	
	int asientos = 5;
	
	//Comprar asientos
	public synchronized void asientosLibres (int cliente, int plazas) {
		
		this.cliente = cliente;
		
		System.out.println("El cliente:" + cliente + " intenta comprar: " + plazas + " plaza/s");
		
		this.comprobacion = asientos;
		
		if (comprobacion - plazas < 0) {
			System.out.println("No hay suficientes plazas");
			
		}
		
		else {
			System.out.println("Quedan plazas libres");
			pagar = true;
		}
		
	}
	
	//Pagar asientos
	public synchronized void asientosPagar (int plazas) {
		try {
			Thread.sleep(3000);
			if (pagar) {
				System.out.println("El cliente: " + cliente  +" ha comprado " + plazas + " plazas");
				System.out.println("El cliente ha pagado los asientos");
				this.asientos = asientos - plazas;
				pagar=false;
			// TODO Auto-generated catch block
		}
			else {
				System.err.println("El cliente no ha pagado las plazas por que no hay suficientes");
			}
		} catch (InterruptedException e) {
			System.err.println("No se ha podido realizar la operacion");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
			
	}
	
	//Reservar asientos
	public synchronized void asientosReserva(int plazas) {
		if (asientos <= 0) {
			System.out.println("No quedan plazas libres");
			System.out.println(" ");
		}
		else {
			System.out.println("Quedan: " + asientos + " libres");
			System.out.println(" ");
		}
		
	}
	
}

//Hilos
class billetes extends Thread {
	
	viajar Viajes;
	
	int compraBilletes;
	
	int cliente;
	
	billetes (viajar Viajes, int cliente){
		
		this.cliente=cliente;
		
		this.Viajes=Viajes;
		
	}
	
	@Override
	public void run() {
		compraBilletes=(int)(Math.random()*(5 - 1)+1);
		Viajes.asientosLibres(cliente,compraBilletes);
		Viajes.asientosPagar(compraBilletes);
		Viajes.asientosReserva(compraBilletes);
	}
	
}










