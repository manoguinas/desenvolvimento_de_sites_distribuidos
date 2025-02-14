import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class BankServer {
  private static final int PORT = 1234;
  private static Map<Integer, Double> accounts = new HashMap<>();
  private static final String ACCOUNT_FILE = "accounts.txt";

  public static void main(String[] args) {
    loadAccounts();
    try (ServerSocket serverSocket = new ServerSocket(PORT)) {
      System.out.println("Servidor bancário iniciado na porta " + PORT);
      while (true) {
        try (Socket clientSocket = serverSocket.accept()) {
          System.out.println("Cliente conectado: " + clientSocket.getInetAddress());
          handleClient(clientSocket);
        }
      }
    } catch (IOException e) {
      System.err.println("Erro no servidor: " + e.getMessage());
    }
  }

  private static void loadAccounts() {
    try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNT_FILE))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(" ");
        int accountNumber = Integer.parseInt(parts[0]);
        double balance = Double.parseDouble(parts[1]);
        accounts.put(accountNumber, balance);
      }
      System.out.println("Contas carregadas com sucesso.");
    } catch (IOException e) {
      System.err.println("Erro ao carregar contas: " + e.getMessage());
    }
  }

  private static void saveAccounts() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACCOUNT_FILE))) {
      for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
        writer.write(entry.getKey() + " " + entry.getValue());
        writer.newLine();
      }
      System.out.println("Contas salvas com sucesso.");
    } catch (IOException e) {
      System.err.println("Erro ao salvar contas: " + e.getMessage());
    }
  }

  private static void handleClient(Socket clientSocket) {
    try (
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
      String request = in.readLine();
      String[] parts = request.split(" ");
      int accountNumber = Integer.parseInt(parts[0]);
      String operation = parts[1];
      double amount = Double.parseDouble(parts[2]);

      String response = processTransaction(accountNumber, operation, amount);
      out.println(response);

      saveAccounts();
    } catch (IOException e) {
      System.err.println("Erro ao lidar com o cliente: " + e.getMessage());
    }
  }

  private static String processTransaction(int accountNumber, String operation, double amount) {
    if (!accounts.containsKey(accountNumber)) {
      return "Erro: Conta não encontrada.";
    }

    double balance = accounts.get(accountNumber);
    if (operation.equalsIgnoreCase("deposito")) {
      balance += amount;
      accounts.put(accountNumber, balance);
      return "Depósito realizado. Novo saldo: " + balance;
    } else if (operation.equalsIgnoreCase("saque")) {
      if (balance >= amount) {
        balance -= amount;
        accounts.put(accountNumber, balance);
        return "Saque realizado. Novo saldo: " + balance;
      } else {
        return "Erro: Saldo insuficiente.";
      }
    } else {
      return "Erro: Operação inválida.";
    }
  }
}
