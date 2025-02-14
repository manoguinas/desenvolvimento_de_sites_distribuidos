import java.io.*;
import java.net.*;

public class BankClient {
  private static final String SERVER_ADDRESS = "localhost";
  private static final int SERVER_PORT = 1234;

  public static void main(String[] args) {
    try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

      System.out.println("Cliente bancário conectado ao servidor.");
      System.out.print("Digite o número da conta: ");
      int accountNumber = Integer.parseInt(userInput.readLine());

      System.out.print("Digite a operação (deposito ou saque): ");
      String operation = userInput.readLine().toLowerCase();

      System.out.print("Digite o valor: ");
      double amount = Double.parseDouble(userInput.readLine());

      out.println(accountNumber + " " + operation + " " + amount);

      String response = in.readLine();
      System.out.println("Resposta do servidor: " + response);

    } catch (IOException e) {
      System.err.println("Erro no cliente: " + e.getMessage());
    }
  }
}
