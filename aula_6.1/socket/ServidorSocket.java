import java.io.*;
import java.net.*;

public class ServidorSocket {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Servidor aguardando conexões...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            double x = Double.parseDouble(in.readLine());
            double y = Double.parseDouble(in.readLine());

            double r = Math.sqrt(x * x + y * y);
            double theta = Math.atan2(y, x) * (180 / Math.PI); 

            String result = String.format("r = %.2f, θ = %.2f graus", r, theta);
            out.println(result);

            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}