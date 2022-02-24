package EjercicioSocketCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Cliente {
	
	private Socket socket;
	
	public BufferedReader entradaDatos;
	
	public PrintWriter salidaDatos;
	
	public Cliente(Socket socket) throws IOException {
		
		this.socket=socket;
		
		entradaDatos = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		salidaDatos = new PrintWriter(socket.getOutputStream(), true);
		
		salidaDatos.flush();
	}
	
	public boolean estaConectado() {
		
		return !socket.isClosed();
	}

	public void socketIsclosed() {
		
		socket.isClosed();
		
	}

}
