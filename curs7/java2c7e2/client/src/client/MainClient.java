package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {

    public static void main(String[] args) throws IOException {
        Socket server = new Socket("localhost", 4545);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        server.getInputStream()
                )
        );

        PrintWriter out = new PrintWriter(
                server.getOutputStream(),
                true
        );

        out.println("Hello ");
        out.println("world");

        String result = in.readLine();

        System.out.println(result);
    }
}
