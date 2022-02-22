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
		
		try {
			
			while(cliente.estaConectado()) {
				
				String mensaje = cliente.entrada.readLine();
				
				if (Character.isDigit(mensaje.charAt(0))) {
					
					System.out.println("Modo sumar");
					
					int numero = Integer.parseInt(mensaje);
					
					servidor.sumatorio(numero);
				}
				
				else if(mensaje.contains("=")) {
					
					servidor.resultado();
				}
				
				else {
					
					System.out.println("Modo mensaje");
					
					servidor.enviarMensajeATodos(mensaje);
				}
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
