package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4545);
        // deschide un proces la portul 4545 care asteapta clienti
        System.out.println("Serverul a pornit la portul 4545");

        System.out.println("Astept clienti...");
        Socket client = ss.accept();

        BufferedReader in = new BufferedReader(
            new InputStreamReader(
                client.getInputStream()
            )
        );

        PrintWriter out = new PrintWriter(
                client.getOutputStream(),
                true
        );

        String s1 = in.readLine();
        System.out.println("Am primit: " + s1);

        String s2 = in.readLine();
        System.out.println("Am primit: " + s2);

        String s3 = s1 + s2;

        out.println(s3);
        System.out.println("Am trimis: " + s3);
    }
}
