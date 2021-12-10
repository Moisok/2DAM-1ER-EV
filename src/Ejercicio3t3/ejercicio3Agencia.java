package Ejercicio3t3;

//Ejercicio 3 tema 3 "agencia de viajes" creado por moises sepulveda segarra

public class ejercicio3Agencia {

	public static void main (String [] args) {
		
		viajar viaje = new viajar();
		
		billetes compra;
		
		
		new billetes(viaje,1).start();
		new billetes(viaje,2).start();
		new billetes(viaje,3).start();
		
		

	}
	
}

//Clase metodo para reservar y pagar el viaje
class viajar {
	
	int cliente;
	
	int plazas;
	
	boolean pagar = false;
	
	int asientos = 5;
	
	//Comprar asientos
	public void asientosLibres (int cliente, int plazas) {
		
		System.out.println("El cliente:" + cliente + " intenta comprar: " + plazas + " asientos");
		
		if (asientos != 0 || asientos < 0) {
			
			System.out.println("Quedan asientos libres");	
		}
		
		else if (asientos <= 0) {
			
			System.out.println("No quedan asientos libres");
		}
		
	}
	
	//Pagar asientos
	public void asientosPagar (int plazas) {
			System.out.println("El cliente ha comprado " + plazas + " plazas");
			System.out.println("El cliente ha pagado los asientos");
			asientos = asientos - plazas;
	}
	
	//Reservar asientos
	public void asientosReserva(int plazas) {
		System.out.println("Quedan: " + asientos + " libres");
		System.out.println("Se han comprado: " + plazas + " plazas");
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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Viajes.asientosPagar(compraBilletes);
		Viajes.asientosReserva(compraBilletes);
		
	}
	
}










