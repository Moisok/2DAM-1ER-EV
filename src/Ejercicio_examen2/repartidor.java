package Ejercicio_examen2;

public class repartidor extends Thread {
	
	private tienda t;
	
	private String repartidor_nombre;
	
	repartidor (tienda t, String repartidor_nombre){
		
		this.t=t;
		
		this.repartidor_nombre = repartidor_nombre;
	}
	
	@Override
	
	public void run() {
		
		for (int i = 0; i<30; i++) {
			
			t.repartirComanda(repartidor_nombre);
			
			try {
				Thread.sleep((int)(Math.random()*(15000-5000)+1000));	
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			t.finalizarPedido(repartidor_nombre);
			
		}
		
	}

}