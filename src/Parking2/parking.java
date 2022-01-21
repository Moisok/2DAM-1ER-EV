package Parking2;

//Hilo para aparcar

class parking extends Thread {
	
	accesRW acceso;
	
	int llegada;
	
	int aparcar;
	
	parking(accesRW acceso){
		
		this.acceso=acceso;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(llegada=(int)(Math.random()*(60000 - 1000)+1000));
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		
		acceso.parking();
		
		try {
			Thread.sleep(aparcar=(int)(Math.random()*(30000-1000)+1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		acceso.salida_parking();
		
	}
}