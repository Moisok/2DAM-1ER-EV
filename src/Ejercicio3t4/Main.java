package Ejercicio3t4;

import java.io.IOException;
import java.net.Socket;

public class Main {

	public static void main(String [] args) {
		
		Servidor server = new Servidor(5555);
		
		try {
		server.iniciar();
		
		while(server.estaConectado()) 
			{
			
			Socket socketCliente = server.aceptarConexion();
			Cliente cliente = new Cliente(socketCliente);
			server.anadirCliente(cliente);
			ConexionCliente conexionCliente =  new ConexionCliente(cliente, server);
			conexionCliente.start();
		}
		
	}catch (IOException e) 
		{
		e.printStackTrace();
		}
}
}
