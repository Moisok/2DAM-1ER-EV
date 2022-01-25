package Ejercicio_examen2;

public class trabajador extends Thread {
	
	private tienda t;
	
	private String trabajador_nombre;
	
	trabajador (tienda t, String trabajador_nombre){
		
		this.t=t;
		
		this.trabajador_nombre = trabajador_nombre;
	}
	
	@Override
	
	public void run() {
		for (int i=0;i<30;i++) {
			t.prepararComanda(trabajador_nombre);
			
			try {
				Thread.sleep((int)(Math.random()*(5000-1000)+1000));	
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			t.ComandaPreparada(trabajador_nombre);
		}
		
	}

}
