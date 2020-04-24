package server;

import server.service.MyServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {

    public static void main(String[] args) throws RemoteException {
        // cream un registru cu implementari remote pe portul 4545
        Registry registry = LocateRegistry.createRegistry(4545);

        // punem in registru o instanta de MyService
        registry.rebind("myService", new MyServiceImpl());
    }
}
