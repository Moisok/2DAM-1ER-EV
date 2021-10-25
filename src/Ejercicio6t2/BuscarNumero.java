package Ejercicio6t2;

//Programa creado por moises Sepulveda Segarra

//Clase para buscar numero
public class BuscarNumero implements Runnable {
	
	private int numero;
	int desde = 2;
    int hasta;
    boolean esPrimo;
	
	public BuscarNumero(int numero) {
		this.numero = numero;
		ConfiguracionIntervalos(numero);	
		
	}
	
	private void ConfiguracionIntervalos(int numero) {
		if (numero == 1) {
			hasta = 1000;
		}
		if (numero == 2) {
			desde = 1000;
			hasta = 2000;
		}
		if (numero == 3) {
			desde = 2000;
			hasta = 3000;
		}
		if (numero == 4) {
			desde = 3000;
			hasta = 4000;
		}	
		if (numero == 5) {
			desde = 4000;
			hasta = 5000;
		}
		if (numero == 6) {
			desde = 5000;
			hasta = 6000;
		}
		if (numero == 7) {
			desde = 6000;
			hasta = 7000;
		}
		if (numero == 8) {
			desde = 7000;
			hasta = 8000;
		}
		if (numero == 9) {
			desde = 9000;
			hasta = 10000;
		}
	}

	//Ahora buscamos los numeros y creamos las filas segun el numero que hemos introducido
	@Override
	public void run() {
		//System.out.println(" ");
		//System.out.println("Hilo: " + numero);
			for (int i = desde; i <= hasta; i++) {
	            esPrimo = true;
	            for (int j = 2; j <= Math.sqrt(i) && esPrimo; j++) {
	                if (i % j == 0) {
	                    esPrimo = false;
	                }
	            }

	            if (esPrimo) {
	                System.out.println(i);
	            }
	        }
		}
		
	
	
	}


	
	

