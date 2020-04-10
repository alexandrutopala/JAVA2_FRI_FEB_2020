package client;

import javax.swing.*;
import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException {
        String username = JOptionPane.showInputDialog("Username:");

        ChatPanel chat = new ChatPanel(username);

        JFrame frame = new JFrame();

        frame.setContentPane(chat.getPanel());

        frame.setTitle(username);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
