package Ejercicio_Url;

import java.net.*;
import java.io.*;



public class h {
    public static void main(String[] args) {
     try {
        // Se abre la conexión
        URL url = new URL("https://tectuinnoweb.uc.r.appspot.com/api/quiero-datos?cant=5&d=25&format=json&key=b0899ba1d24daa20542589c0f521bb1b14688d59&s=1");
        URLConnection conexion = url.openConnection();
        conexion.connect();
        
        // Lectura
        InputStream is = conexion.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String datos = br.readLine();
       
         System.out.println(datos);
     } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
  }
}