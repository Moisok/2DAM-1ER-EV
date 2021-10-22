package Ejercicio6t2;

//Programa creado por moises Sepulveda Segarra

//Clase para buscar numero
public class BuscarNumero implements Runnable {
	
	private int numero;
	int contador = 1;
	int desde = 2;
    int hasta;
    boolean esPrimo;
	
	public BuscarNumero(int numero) {
		this.numero = numero;
	}

	//Ahora buscamos los numeros y creamos las filas segun el numero que hemos introducido
	@Override
	public void run() {
		System.out.println(" ");
		
		//Primos del 1 al 1000
		if (numero == 1) {
			hasta = 1000;
			System.out.println ("Hilo 1");
			for (int i = desde; i <= hasta; i++) {
	            esPrimo = true;
	            for (int j = 2; j <= Math.sqrt(i) && esPrimo; j++) {
	                if (i % j == 0) {
	                    esPrimo = false;
	                }
	            }

	            if (esPrimo) {
	                System.out.print(i);
	                System.out.print(" ");
	            }
	        }
		}
		
		//Primos del 1000 al 2000
		if (numero == 2) {
			desde = 1000;
			hasta = 2000;
			System.out.println ("Hilo 2");
			for (int i = desde; i <= hasta; i++) {
	            esPrimo = true;
	            for (int j = 2; j <= Math.sqrt(i) && esPrimo; j++) {
	                if (i % j == 0) {
	                    esPrimo = false;
	                }
	            }

	            if (esPrimo) {
	                System.out.print(i);
	                System.out.print(" ");
	            }
	        }
		}
		
		//Primos del 2000 al 3000
		if (numero == 3) {
			desde = 2000;
			hasta = 3000;
			System.out.println ("Hilo 3");
			for (int i = desde; i <= hasta; i++) {
	            esPrimo = true;
	            for (int j = 2; j <= Math.sqrt(i) && esPrimo; j++) {
	                if (i % j == 0) {
	                    esPrimo = false;
	                }
	            }

	            if (esPrimo) {
	                System.out.print(i);
	                System.out.print(" ");
	            }
	        }
		}
		
		//Primos del 3000 al 4000
		if (numero == 4) {
			desde = 3000;
			hasta = 4000;
			System.out.println ("Hilo 4");
			for (int i = desde; i <= hasta; i++) {
	            esPrimo = true;
	            for (int j = 2; j <= Math.sqrt(i) && esPrimo; j++) {
	                if (i % j == 0) {
	                    esPrimo = false;
	                }
	            }

	            if (esPrimo) {
	                System.out.print(i);
	                System.out.print(" ");
	            }
	        }
		}
		
		//Primos del 4000 al 5000
		if (numero == 5) {
			desde = 4000;
			hasta = 5000;
			System.out.println ("Hilo 5");
			for (int i = desde; i <= hasta; i++) {
	            esPrimo = true;
	            for (int j = 2; j <= Math.sqrt(i) && esPrimo; j++) {
	                if (i % j == 0) {
	                    esPrimo = false;
	                }
	            }

	            if (esPrimo) {
	                System.out.print(i);
	                System.out.print(" ");
	            }
	        }
		}
		
		//Primos del 5000 al 6000
		if (numero == 6) {
			desde = 5000;
			hasta = 6000;
			System.out.println ("Hilo 6");
			for (int i = desde; i <= hasta; i++) {
	            esPrimo = true;
	            for (int j = 2; j <= Math.sqrt(i) && esPrimo; j++) {
	                if (i % j == 0) {
	                    esPrimo = false;
	                }
	            }

	            if (esPrimo) {
	                System.out.print(i);
	                System.out.print(" ");
	            }
	        }
		}
		
		//Primos del 6000 al 7000
		if (numero == 7) {
			desde = 6000;
			hasta = 7000;
			System.out.println ("Hilo 7");
			for (int i = desde; i <= hasta; i++) {
	            esPrimo = true;
	            for (int j = 2; j <= Math.sqrt(i) && esPrimo; j++) {
	                if (i % j == 0) {
	                    esPrimo = false;
	                }
	            }

	            if (esPrimo) {
	                System.out.print(i);
	                System.out.print(" ");
	            }
	        }
		}
		
		//Primos del 7000 al 8000
		if (numero == 8) {
			desde = 7000;
			hasta = 8000;
			System.out.println ("Hilo 8");
			for (int i = desde; i <= hasta; i++) {
	            esPrimo = true;
	            for (int j = 2; j <= Math.sqrt(i) && esPrimo; j++) {
	                if (i % j == 0) {
	                    esPrimo = false;
	                }
	            }

	            if (esPrimo) {
	                System.out.print(i);
	                System.out.print(" ");
	            }
	        }
		}
		
		//Primos del 8000 al 9000
		if (numero == 9) {
			desde = 9000;
			hasta = 10000;
			System.out.println ("Hilo 9");
			for (int i = desde; i <= hasta; i++) {
	            esPrimo = true;
	            for (int j = 2; j <= Math.sqrt(i) && esPrimo; j++) {
	                if (i % j == 0) {
	                    esPrimo = false;
	                }
	            }

	            if (esPrimo) {
	                System.out.print(i);
	                System.out.print(" ");
	            }
	        }
		}
		System.out.println(" ");
		
	}
	
	

}