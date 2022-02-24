package Sockets_main;



import java.io.IOException;
import Sockets_cliente.cliente;


//Clase principal que hará uso del cliente
public class MainCliente
{
    public static void main(String[] args) throws IOException
    {
        cliente cli = new cliente(); //Se crea el cliente

        System.out.println("Iniciando cliente\n");
        cli.startClient(); //Se inicia el cliente
    }
}