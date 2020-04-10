package server;

import dto.Mesaj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainServer {

    private static List<ClientThread> clienti = new ArrayList<>();
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4545);

        while (true) {
            Socket clientSocket = ss.accept();



            try {
                lock.writeLock().lock();
                ClientThread client = new ClientThread(clientSocket);

                client.start();

                clienti.add(client);
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    public static void trimiteMesajTuturor(Mesaj mesaj) {
        try {
            lock.readLock().lock();

            clienti.forEach(client -> {
                try {
                    client.trimiteMesaj(mesaj);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } finally {
            lock.readLock().unlock();
        }
    }
}
