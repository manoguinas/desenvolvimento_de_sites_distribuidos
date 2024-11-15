import java.rmi.*;
import java.rmi.server.*;

public class CoordenadasImpl extends UnicastRemoteObject implements Coordenadas {
    public CoordenadasImpl() throws RemoteException {
        super();
    }

    @Override
    public String converterParaPolares(double x, double y) throws RemoteException {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x) * (180 / Math.PI);
        return String.format("r = %.2f, θ = %.2f graus", r, theta);
    }
}
