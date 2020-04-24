package client;

import lib.service.MyService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 4545);

        MyService myService = (MyService) registry.lookup("myService");

        String result = myService.reverse("hello");

        System.out.println(result);
    }
}
