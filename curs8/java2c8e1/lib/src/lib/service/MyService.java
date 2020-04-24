package lib.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote marcheaza ca MyService este o interfata
// ale carei metode vor fi invocate remote
public interface MyService extends Remote {

    // RemoteException trebuie obligatoriu propagata
    // de feicare metoda din interfata si marcheaza
    // orice problema care ar putea aparea in comunicarea
    // client-server
    String reverse(String s) throws RemoteException;
}
