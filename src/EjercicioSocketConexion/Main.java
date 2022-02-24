package EjercicioSocketConexion;


import java.io.IOException;
import java.net.Socket;

//Importamos Cliente y servidor
import EjercicioSocketCliente.Cliente;
import EjercicioSocketServidor.Servidor;

public class Main {

	public static void main(String [] args) {
		
		System.out.println("Iniciando conexion");
		Servidor server = new Servidor(5555);
		
		try {
			
		server.iniciar();
		
		System.out.println("Conexion iniciada");
		
		while(server.estaConectado()) 
			{
			
			Socket socketCliente = server.aceptarConexion();
			
			Cliente cliente = new Cliente(socketCliente);
			
			server.anadirCliente(cliente);
			
			ConexionClienteServidor conexionCliente =  new ConexionClienteServidor(cliente, server);
			
			conexionCliente.start();
			
		}
		
		
		
	}catch (IOException e) 
		{
		e.printStackTrace();
		}
		
}
}