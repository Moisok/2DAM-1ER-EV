package Ejercicio_examen2;


public class cliente extends Thread {
	
	private tienda t;
	
	private String cliente_nombre;
	
	cliente (tienda t, String cliente_nombre){
		
		this.t=t;
		
		this.cliente_nombre =  cliente_nombre;
	}

	@Override
	
	public void run() {
		
		try {
			Thread.sleep((int)(Math.random()*(60000-1000)+1000));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		t.introComandas(cliente_nombre);
		
	}
}
