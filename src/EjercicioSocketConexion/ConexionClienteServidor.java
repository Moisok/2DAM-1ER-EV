package EjercicioSocketConexion;

import java.io.IOException;
import EjercicioSocketCliente.Cliente;
import EjercicioSocketServidor.Servidor;

public class ConexionClienteServidor extends Thread {
	
private Cliente cliente;
	
	private Servidor servidor;
	
	public ConexionClienteServidor(Cliente cliente, Servidor servidor) {
		
		this.cliente = cliente;
		
		this.servidor = servidor;
		
	}
	
	public void run() {
		
		cliente.salidaDatos.println("Hola, bienvenidos a SV");
		
		cliente.salidaDatos.println("Elige 1 para modo texto y 2 para modo sumar");
		
		try {
			
			while(cliente.estaConectado()) {	
				
				String mensaje = cliente.entradaDatos.readLine();
				
				if (mensaje.equals("1")) {
					
					cliente.salidaDatos.println("MODO MENSAJE (Escribe exit para salir)");
					
					while(!mensaje.equals("exit")) {
						
						mensaje = cliente.entradaDatos.readLine();
						
						servidor.enviarMensajeATodos(mensaje);
					}
				}
				
				else if (mensaje.contains("2")) {	
					
					cliente.salidaDatos.println("MODO SUMAR (Escribe exit para salir)");
					
					while (!mensaje.equals("exit")) {
						
						mensaje = cliente.entradaDatos.readLine();
						
						if (Character.isDigit(mensaje.charAt(0))) {
							
							int numero = Integer.parseInt(mensaje);	
							
							servidor.sumatorio(numero);
						}
						
						else if(mensaje.equals("=")){
							
							cliente.salidaDatos.println("el resultado es: " + servidor.resultado());
							
						}else {
							
							cliente.salidaDatos.println("ERROR");
						}
					}
				}
				
				else if (mensaje.contains("exit")) {
					
					cliente.salidaDatos.println("Cerrando conexion, gracias por usar el programa");
					
					cliente.socketIsclosed();
					
					servidor.SocketIsclosed();
					
					
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}


