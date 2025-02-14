import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClienteSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String xInput = JOptionPane.showInputDialog("Digite a coordenada X:");
            String yInput = JOptionPane.showInputDialog("Digite a coordenada Y:");

            out.println(xInput);
            out.println(yInput);

            String polarResult = in.readLine();

            JOptionPane.showMessageDialog(null, "Resultado: " + polarResult);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}