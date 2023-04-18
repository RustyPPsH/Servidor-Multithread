import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Servidor extends Thread {
    private Socket con;
    private BufferedReader in;
    private PrintWriter out;

    public Servidor(Socket socket) {
        try {
            con = socket;
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            out = new PrintWriter(con.getOutputStream(), true);
        } catch (IOException ioe) {
            System.err.println("Problemas de IO");
        }
    }

    public void run() {
        try {
            out.println("VAMO ACORDAR! QUEM GANHA DINEHIRO NA CAMA EH PUTA!"); // Escreve ao cliente
            String mensagem = "";
            while ((mensagem = in.readLine()) != null) {
                System.out.println(mensagem);
            }
        } catch (IOException ioe) {
            System.err.println("Problemas de IO");
        }
    }
}
