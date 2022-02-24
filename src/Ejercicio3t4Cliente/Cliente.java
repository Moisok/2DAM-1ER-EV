package Ejercicio3t4Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	public Socket socket;
	
	public BufferedReader entrada;
	
	public PrintWriter salida;
	
	
	public Cliente(Socket socket) throws IOException {
		
		this.socket=socket;
		
		entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		salida = new PrintWriter(socket.getOutputStream(), true);
		
		salida.flush();
	}
	
	public boolean estaConectado() {
		
		return !socket.isClosed();
		
	}
	
}