import java.rmi.*;
import javax.swing.*;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            Coordenadas coord = (Coordenadas) Naming.lookup("//localhost/Coordenadas");

            String xInput = JOptionPane.showInputDialog("Digite a coordenada X:");
            String yInput = JOptionPane.showInputDialog("Digite a coordenada Y:");

            double x = Double.parseDouble(xInput);
            double y = Double.parseDouble(yInput);

            String result = coord.converterParaPolares(x, y);

            JOptionPane.showMessageDialog(null, "Resultado: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}