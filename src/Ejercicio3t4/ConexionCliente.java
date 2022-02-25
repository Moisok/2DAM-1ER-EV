package Ejercicio3t4;

import java.io.IOException;

public class ConexionCliente extends Thread {

	private Cliente cliente;
	
	private Servidor servidor;
	
	public ConexionCliente(Cliente cliente, Servidor servidor) {
		
		this.cliente = cliente;
		
		this.servidor = servidor;
		
	}
	
	public void run() {
		
		cliente.salida.println("Hola, bienvenidos a SV");
		cliente.salida.println("Elige 1 para modo texto y 2 para modo sumar");
		
		try {
			while(cliente.estaConectado()) {	
				String mensaje = cliente.entrada.readLine();
				if (mensaje.equals("1")) {
					cliente.salida.println("MODO MENSAJE (Escribe exit para salir)");
					while(!mensaje.equals("exit")) {
						mensaje = cliente.entrada.readLine();
						servidor.enviarMensajeATodos(mensaje);
					}
				}
				if (mensaje.contains("2")) {		
					cliente.salida.println("MODO SUMAR (Escribe exit para salir)");
					while (!mensaje.equals("exit")) {
						mensaje = cliente.entrada.readLine();
						if (Character.isDigit(mensaje.charAt(0))) {
							int numero = Integer.parseInt(mensaje);		
							servidor.sumatorio(numero);
						}
						else if(mensaje.equals("=")){
							cliente.salida.println("el resultado es: " + servidor.sumar);
						}else {
							cliente.salida.println("ERROR");
						}
					}
					
				}
				
	
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
