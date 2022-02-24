package EjercicioSocketServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import EjercicioSocketCliente.Cliente;

public class Servidor {

	public int sumar = 0;
	
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
			cliente.salidaDatos.println(mensaje);
		}
	}
	
	//Metodos de sumar
	public void sumatorio(int numero) {
		sumar = sumar + numero;
	}
	
	public int resultado() {
		return sumar;
	}

	public void SocketIsclosed() {
		socket.isClosed();
		
	}
	
	}
