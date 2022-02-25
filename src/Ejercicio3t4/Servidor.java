package Ejercicio3t4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	int sumar = 0;
	
	private ServerSocket socket; 
	//Pots rebre connexions des d'altres equips
	private int puerto; //Port guardat
	
	private ArrayList<Cliente> clientes;
	
	public Servidor(int puerto) {
		
		this.puerto = puerto;
		
		clientes = new ArrayList<Cliente>();
	}
	
	public void iniciar() throws IOException {
		socket = new ServerSocket(puerto); //Assignem port al SV socket
	}
	public void parar()  throws IOException {
		socket.close();
	}
	
	public boolean estaConectado() {
		return !socket.isClosed();
	}
	
	public Socket aceptarConexion() throws IOException {
		return socket.accept();
	}
	
	public void anadirCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void enviarMensajeATodos(String mensaje) {
		for(Cliente cliente : clientes) 
		{
			cliente.salida.println("Usuario ha enviado: " + mensaje);
		}
	}
	
	//Metodos de sumar
	public void sumatorio(int numero) {
		sumar = sumar + numero;
	}
	
	//Metodo para COmunicarse
	public void operar(String comunicar) {
		
		
	}
	

}

/*try {
			
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
						}
					}
					
				}
				
	
			}
		}catch(IOException e) {
			e.printStackTrace();
		}*/