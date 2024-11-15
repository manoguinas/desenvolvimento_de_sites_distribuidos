import java.rmi.*;
import java.rmi.registry.*;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            CoordenadasImpl obj = new CoordenadasImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("Coordenadas", obj);
            System.out.println("Servidor RMI pronto.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}