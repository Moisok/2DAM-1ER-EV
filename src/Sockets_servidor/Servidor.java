package Sockets_servidor;

import Sockets_Conexion.conexion;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Servidor extends conexion {
	
	public Servidor() throws IOException{super("servidor");}
	
	public void startServer() { //Este metodo es para iniciar el servidor
		
		try {
			
			System.out.println("Esperando conexion·...");
			
			socketCliente = socketServidor.accept(); //Aqui se espera la conexion por parte del cliente
			
			System.out.println("Cliente en linea");
			
			//Se obtiene el flujo de salida del cliente para enviar mensajes para enviar mensajes
			salidaCliente  = new DataOutputStream(socketCliente.getOutputStream());
			
			//Se envia mensaje a cliente usando su flujo de salida
			salidaCliente.writeUTF("Peticion recibida y aceptada");
			
			//Se obtiene el flujo entrante desde el cliente
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			
			//Este bucle es mientras haya mensajes desde cliente
			while((mensajeServidor = entrada.readLine()) != null) {
				System.out.println(mensajeServidor);
			}
			
			System.out.println("Fin de la conexion");
			
			socketServidor.close();
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
	}

}
