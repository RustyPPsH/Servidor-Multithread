import java.net.*;
import java.io.*;

public class Principal {

  
    public static void main(String[] args) {
        try {
            int contadorCliente = 0;
            ServerSocket servidor = new ServerSocket(6969);
            System.out.println("Aguardando cliente!");
            while (true) {
                Socket socket = servidor.accept(); // espera
                Servidor cliente = new Servidor(socket);
                System.out.println("Chegou um cliente!");
                contadorCliente++;
                System.out.println(contadorCliente + " clientes se conectaram desde o inicio do programa");
                cliente.start();
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }
    }
}