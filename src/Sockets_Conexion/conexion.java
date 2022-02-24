package Sockets_Conexion;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class conexion {
		//Puerto de conexion
		private final int puerto = 5555; 
		
		//Nombre del host
		private final String host = "localhost";
		
		//Mensaje entrantes recibidos en servidor
		protected String mensajeServidor;
		
		//Socket de server
		protected ServerSocket socketServidor;
		
		//Sockeet del cliente
		protected Socket socketCliente;
		
		//Datos de salida (flujo)
		protected DataOutputStream salidaServidor, salidaCliente;
		
		//Metodo para la Conexion
		public conexion (String tipo) throws IOException{
			if(tipo.equalsIgnoreCase("servidor")) {
				socketServidor = new ServerSocket(puerto); //Creamos socket para el servidor 5555
				socketCliente = new Socket(); //Socket para cliente
			}else {
				socketCliente = new Socket(host, puerto);
			}
		}
		
	
		
}
