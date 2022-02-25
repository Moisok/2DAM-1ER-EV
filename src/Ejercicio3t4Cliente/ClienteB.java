package Ejercicio3t4Cliente;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteB {

    public static void main(String[] args) throws IOException {
        String hostname = "hostname";
        int port = 5555;

        //InetAddress address = InetAddress.getByName(hostname);
        //DatagramSocket socket = new DatagramSocket();

        //byte[] buffer = new byte[512];

        //DatagramPacket request = new DatagramPacket(buffer, buffer.length, address, port);
        
        //socket.send(request);
        
    	BufferedReader entrada;
    	
    	PrintWriter salida;
    	
        Socket socket = new Socket (hostname, port);
        
		entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		salida = new PrintWriter(socket.getOutputStream(), true);
        
        
    }

}
