//https://www.programarya.com/Cursos-Avanzados/Java/Sockets

package Sockets_cliente;

import Sockets_Conexion.conexion;
import java.io.DataOutputStream;
import java.io.IOException;


public class cliente extends conexion
{
    public cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(socketCliente.getOutputStream());

            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Este es el mensaje número " + (i+1) + "\n");
            }

            socketCliente.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}   
