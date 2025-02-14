import java.rmi.*;

public interface Coordenadas extends Remote {
    String converterParaPolares(double x, double y) throws RemoteException;
}
