package Parking2;

//Hilo para aparcar

class parking extends Thread {
	
	accesRW acceso;
	
	parking(accesRW acceso){
		
		this.acceso=acceso;
	}
	
	@Override
	public void run() {
		
		acceso.parking();
		
		acceso.salida_parking();
		
	}
}